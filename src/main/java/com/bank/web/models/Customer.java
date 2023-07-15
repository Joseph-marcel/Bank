package com.bank.web.models;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Customer implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min=2, max=25)
	private String firstName;
	@NotNull
	@Size(min=3, max=50)
	private String lastName;
	@NotNull
	@Email
	private String email;
	
	
	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Collection<Account> accounts;


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Collection<Account> getAccounts() {
		return accounts;
	}


	public void setAccounts(Collection<Account> accounts) {
		this.accounts = accounts;
	}

}
