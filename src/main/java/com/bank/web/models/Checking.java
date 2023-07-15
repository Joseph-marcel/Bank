package com.bank.web.models;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("AC") 
public class Checking extends Account{

	private double overDraft;

	public Checking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Checking(String code, Date dateCreation, double balance, Customer customer, double overDraft) {
		super(code, dateCreation, balance, customer);
		this.overDraft = overDraft;
	}

	public double getOverDraft() {
		return overDraft;
	}

	public void setOverDraft(double overDraft) {
		this.overDraft = overDraft;
	}
	
}
