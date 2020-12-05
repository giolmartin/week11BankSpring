package com.meritamerica.week11.models;

import java.util.Date;

import com.meritamerica.week11.exceptions.NoSuchResourceFoundException;

;

public class CheckingAccount extends BankAccount{
	
	
	private static final double INTEREST_RATE = .0001;
	
	
	
	
	public CheckingAccount(double balance)   {
		super(balance, INTEREST_RATE);
		
		
	}
	 public CheckingAccount()  {
		 super(INTEREST_RATE);
		 }
	
	

	
}
