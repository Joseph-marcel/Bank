package com.bank.web.models;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("D") 
public class Debit extends Operation{

	public Debit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Debit(Date dateOperation, double amount, Account account) {
		super(dateOperation, amount, account);
		// TODO Auto-generated constructor stub
	}

	
	
    
}
