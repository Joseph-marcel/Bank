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
		
	}
}
