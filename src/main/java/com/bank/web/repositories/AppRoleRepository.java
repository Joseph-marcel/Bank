package com.bank.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.web.configuration.userDetailsConfig.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, String>{

}
