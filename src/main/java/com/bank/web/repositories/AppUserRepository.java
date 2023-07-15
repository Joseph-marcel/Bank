package com.bank.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.web.configuration.userDetailsConfig.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String>{

	AppUser findByUsername(String username);
}
