package com.meritamerica.week11.models;

import javax.validation.constraints.NotBlank;

public class CDOffering {

	@NotBlank(message = "Term of investment Missing")
	private int term;
	
	@NotBlank(message = "Interest Rate Missing")
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
