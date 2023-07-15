package com.bank.web.models;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("AS") 
public class Saving extends Account{
    
	private double rate;

	public Saving() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Saving(String code, Date dateCreation, double balance, Customer customer, double rate) {
		super(code, dateCreation, balance, customer);
		this.rate = rate;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}
