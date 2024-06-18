package com.bank.web.serviceImpl;

import java.util.UUID;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bank.web.configuration.userDetailsConfig.AppRole;
import com.bank.web.configuration.userDetailsConfig.AppUser;
import com.bank.web.repositories.AppRoleRepository;
import com.bank.web.repositories.AppUserRepository;
import com.bank.web.service.CustomUserDetailService;
import lombok.AllArgsConstructor;


@Service
@Transactional
@AllArgsConstructor
public class CustomUserDetailServiceImpl implements CustomUserDetailService{
	
	
	private AppUserRepository   appUserRepo;
	
	
	private AppRoleRepository   appRoleRepo;
	
	
	private PasswordEncoder     passwordEncoder;

	
	
	@Override
	public AppUser addNewUser(String username, String password, String email, String confirmPassword) {
		// TODO Auto-generated method stub
		AppUser appUser = loadUserByUsername(username);
		if(appUser != null) throw new RuntimeException("User already exist");
		if(!password.equals(confirmPassword)) throw new RuntimeException("Password does not match");
		
		 appUser = AppUser.builder()
		        .userId(UUID.randomUUID().toString())
		        .username(username)
		        .password(passwordEncoder.encode(password))
		        .email(email)
		        .build();
		 appUserRepo.save(appUser);
		 
		 return appUser;
		
	}

	@Override
	public AppRole addNewRole(String role) {
		// TODO Auto-generated method stub
		AppRole appRole = (AppRole) appRoleRepo.findById(role).orElse(null);
		if(appRole!= null) throw new RuntimeException("Role already exist");
		appRole = AppRole.builder()
				         .role(role)
				         .build();
		 
		
		return appRoleRepo.save(appRole);
	}

	@Override
	public void addRoleToUser(String username, String role) {
		// TODO Auto-generated method stub
		AppUser appUser = loadUserByUsername(username);
		AppRole appRole = appRoleRepo.findById(role).orElse(null);
		
		appUser.getRoles().add(appRole);
	}

	@Override
	public void removeRoleFromUser(String username, String role) {
		// TODO Auto-generated method stub
		AppUser appUser = loadUserByUsername(username);
		AppRole appRole = appRoleRepo.findById(role).get();
		
		appUser.getRoles().remove(appRole);
		
	}

	@Override
	public AppUser loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		return appUserRepo.findByUsername(username);
	}

	
}
