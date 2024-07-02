package com.bank.web.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class SavingDto extends AccountDto{

	private double rate;
}
