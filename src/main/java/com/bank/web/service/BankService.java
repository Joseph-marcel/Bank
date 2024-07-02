package com.bank.web.service;


import org.springframework.data.domain.Page;
import com.bank.web.models.Account;
import com.bank.web.models.Customer;
import com.bank.web.models.Operation;


public interface BankService {
	
	//CRUD Customer Entity
	Customer createCustomer(Customer cstm);
    Customer searchCustomer(Long id);
    Customer modifyCustomer(Long id, Customer cstm);
	void deleteCustomer(Long id);
	Customer saveCustomer(Customer ctsm);
	Page<Customer> findAllCustomers(int page, int size);
	
	
	//CRUD Account Entity
	Account addAccount(Account act);
	Account consultAccount(String code);
	Account modifyAccount(String code, Account act);
	void deleteAccount(String act);
	Account saveAccount(Account account);
	Page<Account> findAllAccount(int page,int size);
	
	
	void newCredit(String code, double amount);
	void newDebit(String code, double amount);
	void transfer(String code1,String code2, double amount);
	Page<Operation> listOperations(String code,int page,int size);
	

}
