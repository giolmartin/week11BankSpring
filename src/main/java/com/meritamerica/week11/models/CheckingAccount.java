package com.meritamerica.week11.models;

import java.util.Date;

;

public class CheckingAccount extends BankAccount{
	
	
	private static double interestRate = .0001;
	
	
	
	
	public CheckingAccount(double balance) {
		super(MeritBank.getNextAccountNumber(), balance , interestRate);
		
	}
	
	

	
}
