package com.bank.web.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CheckingDto extends AccountDto{

	private double overDraft;
}
