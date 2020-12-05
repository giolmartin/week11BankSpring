package com.meritamerica.week11.models;

import java.util.Date;

import com.meritamerica.week11.exceptions.NoSuchResourceFoundException;

;

public class CheckingAccount extends BankAccount{
	
	
	private static double interestRate = .0001;
	
	
	
	
	public CheckingAccount(double balance)   {
		super(balance, .0001);
		
		
	}
	 public CheckingAccount()  {
		 super(0.0001);
		 }
	
	

	
}
