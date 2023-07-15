package com.bank.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Component;

import com.bank.web.configuration.userDetailsConfig.AppRole;
import com.bank.web.configuration.userDetailsConfig.AppUser;
import com.bank.web.controller.BankController;
import com.bank.web.models.Account;
import com.bank.web.models.Checking;
import com.bank.web.models.Customer;
import com.bank.web.models.Operation;
import com.bank.web.models.Saving;
import com.bank.web.repositories.AccountRepository;
import com.bank.web.repositories.CustomerRepository;
import com.bank.web.repositories.OperationRepository;
import com.bank.web.service.BankService;
import com.bank.web.service.CustomUserDetailService;
import com.bank.web.serviceImpl.UserDetailServiceImpl;

@SpringBootApplication
public class BankApplication implements CommandLineRunner{
	
//	@Autowired
	private CustomerRepository cstmRepo;
	
//	@Autowired
	private AccountRepository actRepo;
	
//	@Autowired
	private OperationRepository optRepo;
	
//	@Autowired
	private BankService iBank;
	
//	@Autowired
	private JdbcUserDetailsManager jdbcM;
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
//    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    
    
	
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		Customer cstm1 = cstmRepo.save(new Customer("jean", "Bislot", "bislo@hotmail.fr"));
//		Customer cstm2 = cstmRepo.save(new Customer("John", "Blisso", "bli@yahoo.fr"));
//		Customer cstm3 = cstmRepo.save(new Customer("Jules", "Biso", "sbi@yahoo.fr"));
//		
//		Account act1 = actRepo.save(new Saving("ac1", new Date(), 50000, cstm3, 2.5));
//		Account act2 = actRepo.save(new Saving("ac2", new Date(), 50000, cstm2, 2.5));
//		Account act3 = actRepo.save(new Checking("ac3", new Date(), 30000, cstm1, 25000)) ;
		
//		UserDetails u1 = jdbcM.loadUserByUsername("user1");
//		
//		if(u1 == null) {
//			jdbcM.createUser(User.withUsername("user1")
//		              .password(passwordEncoder.encode("12345"))
//		              .roles("USER")
//		              .build()
//		              );
//		}
//		
//		UserDetails u2 = jdbcM.loadUserByUsername("user2");
//		if(u2 == null) {
//			jdbcM.createUser(User.withUsername("user2")
//		              .password(passwordEncoder.encode("123456"))
//		              .roles("USER")
//		              .build()
//		              );
//		}
//		 
//		 
//		 UserDetails u3 = jdbcM.loadUserByUsername("admin");
//		 if(u3 == null) {
//			 jdbcM.createUser(User.withUsername("admin")
//		              .password(passwordEncoder.encode("1234567"))
//		              .roles("USER","ADMIN")
//		              .build()
//		              );
//			
//		 }
		 
//		iBank.newCredit(act3.getCode(), 25000);
//		iBank.newDebit(act2.getCode(), 25000);
//		iBank.transfer(act2.getCode(), act1.getCode(), 20000);
		
//		Page<Operation> pageOperations = iBank.listOperations("ac3", 0, 5);
//		
//		System.out.println(pageOperations.getTotalPages());
		
//	    AppUser user1 = customUserDetailService.addNewUser("user1", "4567", "fredo@yahoo.com", "4567");
//		AppUser user2 = customUserDetailService.addNewUser("user2", "45678", "fredo2@yahoo.com", "45678");
//		AppUser user3 = customUserDetailService.addNewUser("admin", "456789", "ado@yahoo.com", "456789");
//		
//		AppRole user = customUserDetailService.addNewRole("USER");
//		AppRole admin = customUserDetailService.addNewRole("ADMIN");
//		 
//		customUserDetailService.addRoleToUser(user1.getUsername(), user.getRole());
//		customUserDetailService.addRoleToUser(user2.getUsername(), user.getRole());
//		customUserDetailService.addRoleToUser(user3.getUsername(), admin.getRole());
	    
	}
	
	

}
