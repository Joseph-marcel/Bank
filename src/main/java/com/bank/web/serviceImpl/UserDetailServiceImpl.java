package com.bank.web.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bank.web.configuration.userDetailsConfig.AppUser;
import com.bank.web.service.CustomUserDetailService;
import lombok.AllArgsConstructor;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private CustomUserDetailService customUser;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		AppUser appUser = customUser.loadUserByUsername(username);
		if(appUser == null) throw new UsernameNotFoundException(String.format("User %s not found", username));
		
		String[] roles = appUser.getRoles().stream().map(u -> u.getRole()).toArray(String[]::new);
		UserDetails userDetails = User
				.withUsername(appUser.getUsername())
			    .password(appUser.getPassword())
			    .roles(roles)
			    .build();
		
		return userDetails;
	}

}
