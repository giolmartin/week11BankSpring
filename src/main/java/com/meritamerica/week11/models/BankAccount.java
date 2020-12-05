package com.meritamerica.week11.models;




public abstract class BankAccount {
	private double balance;
	private double interestRate;
	private long accountNumber;
	private String date = "01/02/2020";
	
	public BankAccount(double interestRate) {
		this.accountNumber = MeritBank.getNextAccountNumber();
		this.balance = 0;
		this.interestRate=interestRate;
		date= "01/02/2020";
	}
	
	BankAccount(double balance, double interestRate){
		this.balance = balance;
		this.interestRate = interestRate;
		accountNumber = MeritBank.getNextAccountNumber();
	}

	BankAccount(long accountNumber, double balance, double interestRate){
		 this.accountNumber = accountNumber;
		 this.balance = balance;
		 this.interestRate = interestRate;
	 }
	
	BankAccount(long accountNumber, double balance, double interestRate, String date){
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		this.date= date;
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
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
