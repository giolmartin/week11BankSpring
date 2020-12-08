package com.meritamerica.week11.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.ResponseStatus;

import com.meritamerica.week11.exceptions.*;

public abstract class BankAccount  {
	
	private static final double  MAX_COMBINED_AMOUNT= 250000;

	private long accountNumber;
	
	@Min(value = 0L, message = "Balance Lower Than 0 Exception")
	private double balance;
	
	@NotNull(message = "Interest Rate Missing")
	@Min(value = 0L)
	@Max(value = 1)
	private double interestRate;
	
	private String openedOn;

	public  BankAccount() { 
		this.accountNumber = MeritBank.getNextAccountNumber();
		openedOn = "1234566";
		}
	
	public BankAccount(double interestRate) {
		this.accountNumber = MeritBank.getNextAccountNumber();	
		this.balance = 0 ;
		this.interestRate=interestRate;
		openedOn = "123123141423";
	}
	
	BankAccount(double balance, double interestRate){
		this.accountNumber = MeritBank.getNextAccountNumber();
		this.balance = balance;
		this.interestRate = interestRate;
		openedOn = "123123141423";
	}


	
	public double getBalance() {
		return balance;
	}

//Here added the balance negative Exception that way the object isn't created. Or is it?
	public void setBalance(double balance)  {
			this.balance = balance;	
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
	

}
