package com.meritamerica.week11.models;

public class CDAccount extends BankAccount{

	private CDOffering cdOffering;
	private int term;
	private double interestRate;
	
	
	
	public CDAccount() {
		super();
	}
	public CDAccount(CDOffering cdOffering, double balance) {
		super(balance, cdOffering.getInterestRate(), cdOffering.getTerm());
		
	}
	
	
}
