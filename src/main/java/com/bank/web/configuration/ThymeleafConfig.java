package com.bank.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;

@Configuration
public class ThymeleafConfig {

	public class LeafConfig {
        @Bean
        SpringSecurityDialect springSecurityDialect(){
            return new SpringSecurityDialect();
        }
    }
}
