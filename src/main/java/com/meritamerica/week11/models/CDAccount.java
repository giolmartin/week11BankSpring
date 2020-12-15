package com.meritamerica.week11.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CD_ACCOUNTS")
public class CDAccount extends BankAccount{


	@Min(value = 1)
	private int term;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "account_id")
	private AccountHolder accountHolders;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = CDOffering.class)
	@JoinColumn(name = "offerings_id", referencedColumnName = "offerings_id")
	private CDOffering cdOffering;

	public CDOffering getCdOffering() {
		return cdOffering;
	}

	public void setCdOffering(CDOffering cdOffering) {
		this.cdOffering = cdOffering;
	}
	
	@JsonIgnore
	public AccountHolder getAccountHolders() {
		return accountHolders;
	}

	public void setAccountHolders(AccountHolder accountHolders) {
		this.accountHolders = accountHolders;
	}

	public CDAccount() {
		super();
	}
	public CDAccount( double balance, double interestRate, int term) {
		super(balance, interestRate);
		this.term = term;
		
	}
	
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	
	
}
