package com.bank.web.dto;

import lombok.Data;

@Data
public abstract class AccountDto {

	private String code;
	private double balance;
}
