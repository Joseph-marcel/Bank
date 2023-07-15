package com.bank.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.web.models.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

}
