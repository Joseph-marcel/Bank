package com.bank.web.models;


import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name="ACCOUNT_TYPE", discriminatorType = DiscriminatorType.STRING,length=2) 
public abstract class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String code;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateCreation;
	private double balance;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="customer_id",nullable=false)
	private Customer customer;
	
	@OneToMany(mappedBy="account",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Collection<Operation> mouvements;
	
	protected Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected Account(String code, Date dateCreation, double balance, Customer customer) {
		super();
		this.code = code;
		this.dateCreation = dateCreation;
		this.balance = balance;
		this.customer = customer;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<Operation> getMouvements() {
		return mouvements;
	}

	public void setMouvements(Collection<Operation> mouvements) {
		this.mouvements = mouvements;
	}

}
