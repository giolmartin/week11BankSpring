package com.meritamerica.week11.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SAVINGS_ACCOUNTS")
public class SavingsAccount extends BankAccount {

	
	private static final double INTEREST_RATE = 0.001 ;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "account_id")
	private AccountHolder accountHolders;
	
	@JsonIgnore
	public AccountHolder getAccountHolders() {
		return accountHolders;
	}

	public void setAccountHolders(AccountHolder accountHolders) {
		this.accountHolders = accountHolders;
	}
	public SavingsAccount() {
		super(INTEREST_RATE);
	}
	
	public SavingsAccount(double balance) {
		super(balance,INTEREST_RATE);
		}

	
	
}
