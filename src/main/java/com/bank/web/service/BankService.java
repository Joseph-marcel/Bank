package com.bank.web.service;


import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.bank.web.models.Account;
import com.bank.web.models.Customer;
import com.bank.web.models.Operation;


public interface BankService {
	
	//CRUD Customer Entity
	public Customer createCustomer(Customer cstm);
	public Customer searchCustomer(Long id);
	public Customer modifyCustomer(Long id, Customer cstm);
	public void deleteCustomer(Long id);
	public Page<Customer> listCustomers(int page, int size);
	public Customer saveCustomer(Customer ctsm);
	public Collection<Customer> findAllCustomers();
	
	
	//CRUD Account Entity
	public Account addAccount(Account act);
	public Account consultAccount(String code);
	public Account modifyAccount(String code, Account act);
	public void deleteAccount(String act);
	public Account saveAccount(Account account);
	public Page<Account> findAllAccount(int page,int size);
	
	
	public void newCredit(String code, double amount);
	public void newDebit(String code, double amount);
	public void transfer(String code1,String code2, double amount);
	public Page<Operation> listOperations(String code,int page,int size);

}
