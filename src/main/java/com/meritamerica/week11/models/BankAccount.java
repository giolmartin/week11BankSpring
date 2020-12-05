package com.meritamerica.week11.models;

import javax.validation.constraints.Min;


import org.springframework.web.bind.annotation.ResponseStatus;

import com.meritamerica.week11.exceptions.*;

public abstract class BankAccount  {
	
	private static final double  MAX_COMBINED_AMOUNT= 250000;
	//private long nextAccountNumber = MeritBank.getNextAccountNumber();
	private long accountNumber;
	private double balance;
	private double interestRate;
	private String openedOn;
	
	private int term;
	
	public  BankAccount() {}
	public BankAccount(double interestRate) {
	//changed this and Calling the meritAmerica.getNextAccountNumber on the getter, see line 70
		//now account numbers appear sequential on postman even after entering a negative number
		
		this.accountNumber = MeritBank.getNextAccountNumber();
		this.balance = 0 ;
		this.interestRate=interestRate;
		openedOn = "123123141423";
	}
	
	BankAccount(double balance, double interestRate){
		this.balance = balance;
		this.interestRate = interestRate;
		accountNumber = MeritBank.getNextAccountNumber();
	}

	BankAccount(long accountNumber, double balance, double interestRate) {
	
		 this.accountNumber = MeritBank.getAccountNumber();
		 this.balance = balance;
		 this.interestRate = interestRate;
	 }
	
	BankAccount(long accountNumber, double balance, double interestRate, String openedOn) {
		
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		this.openedOn= openedOn;
	}
	
	BankAccount(double balance, double interestRate, int term){
		this.accountNumber = MeritBank.getNextAccountNumber();
		this.balance = balance;
		this.interestRate = interestRate;
		this.term = term;
	}
	
	public double getBalance() {
		return balance;
	}

//Here added the balance negative Exception that way the object isn't created. Or is it?
	public void setBalance(double balance) throws NegativeBalanceException {
		//double combinedBalance = MeritBank.getAccountHolders() ;
		if(balance > 0 ) {
			this.balance = balance;
		} else {
			throw new NegativeBalanceException("Negative Balance Not Accepted");
		} 
	
		
	}
	 public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getOpenedOn() {
		return openedOn;
	}

	public void setOpenedOn(String openedOn) {
		this.openedOn = openedOn;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	
}
