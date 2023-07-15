package com.bank.web.models;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("C") 
public class Credit extends Operation{

	public Credit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Credit(Date dateOperation, double amount, Account account) {
		super(dateOperation, amount, account);
		// TODO Auto-generated constructor stub
	}

	

}
