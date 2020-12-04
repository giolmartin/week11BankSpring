package com.meritamerica.week11.models;

import java.util.Date;

;

public class CheckingAccount extends BankAccount{
	private  int accountNumber;
	private double balance;
	private static double interestRate = .0001;
	private static String date ;
	
	
	
	public CheckingAccount(double b) {
		super(MeritBank.getNextAccountNumber(), b , interestRate, date);
		
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public double getInterestRate() {
		return interestRate;
	}


	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}


	public static String getDate() {
		return date;
	}


	public static void setDate(String date) {
		CheckingAccount.date = date;
	}


	
}
