package com.bank.web.customException;

public class TransferToSameAccountNotPossibleException extends RuntimeException{

private static final long serialVersionUID = 1L;
	
	public TransferToSameAccountNotPossibleException(String s) {
		super(s);
	}
}
