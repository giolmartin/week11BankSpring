package com.meritamerica.week11.models;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

@Entity
@Table(name = "	CD_OFFERINGS")
public class CDOffering {

	@Id
	@GeneratedValue
	@Column(name = "offerings_id")
	private int id;
	
	@Min(value = 1)
	private int term;
	
	@DecimalMin(value = "0.0", inclusive = false, message = "Interest must be greater than 0")
	@DecimalMax(value = "1.0", inclusive = false, message = "Interest rate must be lower than 1")
	private double interestRate;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "offerings_id", referencedColumnName = "offerings_id")
	private List<CDAccount> cdAccounts;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<CDAccount> getCdAccount() {
		return cdAccounts;
	}

	public void setCdAccount(List<CDAccount> cdAccounts) {
		this.cdAccounts = cdAccounts;
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
	
	public  CDOffering() {
		
	}
	
	public CDOffering(int term, double interestRate) {
		this.term = term;
		this.interestRate = interestRate;
	}
	
}
