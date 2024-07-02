package com.bank.web.dto;

import java.util.Date;

import lombok.Data;
@Data
public abstract class OperationDto {

	private Long number;
	private Date dateOperation;
	private double amount;
	private AccountDto Account;
}
