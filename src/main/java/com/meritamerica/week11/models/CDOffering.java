package com.meritamerica.week11.models;


import javax.validation.constraints.*;

public class CDOffering {

	@NotNull(message = "Term of investment Missing")
	@Min(value = 1)
	private int term;
	
	@NotNull(message = "Interest Rate Missing")
	@Min(value = 0L)
	@Max(value = 1)
	private double interestRate;
	
	public  CDOffering() {
		
	}
	
	public CDOffering(int term, double interestRate) {
		this.term = term;
		this.interestRate = interestRate;
	}
	
	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
