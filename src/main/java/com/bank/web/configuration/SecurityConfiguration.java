package com.bank.web.configuration;



import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import com.bank.web.serviceImpl.UserDetailServiceImpl;
import lombok.AllArgsConstructor;



@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfiguration{
	
	
	
	private UserDetailServiceImpl userDetailServiceImpl;

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}


//    @Bean
    JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
    	
    	return new JdbcUserDetailsManager(dataSource);
    }
    


    @Bean
    SecurityFilterChain web(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeHttpRequests(
	                authorize -> authorize.requestMatchers("/index","/consultAccount")
	                    .permitAll()
	                    .requestMatchers("/indexCustomers","/indexAccounts",
	                    		"/formCustomer","formAccount","saveOperation")
	                    .hasRole("ADMIN")
	                    .anyRequest()
	                    .authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/index", true)
                )
                .logout(logout -> logout.permitAll())
                .exceptionHandling((exceptionHandling) -> exceptionHandling.accessDeniedPage("/403"))
                .userDetailsService(userDetailServiceImpl)
                .rememberMe(Customizer.withDefaults());
        
                return httpSecurity.build();
        
        }
    
}
