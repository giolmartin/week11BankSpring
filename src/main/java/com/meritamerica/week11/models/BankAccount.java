package com.meritamerica.week11.models;

public abstract class BankAccount {
	private double balance;
	private double interestRate;
	private long accountNumber;
	private String date;
	
	BankAccount(double balance, double interestRate){
		this.balance = balance;
		this.interestRate = interestRate;
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
	
}
