package com.bank.web.customException;


public class InsuffisantBalanceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InsuffisantBalanceException(String s) {
		super(s);
	}

}
