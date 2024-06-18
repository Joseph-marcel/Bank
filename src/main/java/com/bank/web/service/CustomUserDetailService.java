package com.bank.web.service;

import com.bank.web.configuration.userDetailsConfig.AppRole;
import com.bank.web.configuration.userDetailsConfig.AppUser;


public interface CustomUserDetailService {
	
	AppUser addNewUser(String username,String password,String email,String confirmPassword);
	AppRole addNewRole(String role);
	void    addRoleToUser(String username,String role);
	void removeRoleFromUser(String username,String role);
	AppUser loadUserByUsername(String username);

}
