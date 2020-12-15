package com.meritamerica.week11.models;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "ACCOUNT_HOLDER")
public class AccountHolder {

	private static final long  MAX_COMBINED_AMOUNT= 250000;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;



	@NotBlank(message = "Name may not be empty")
	//@Size(min = 2, max = 32, message = "Name must be between 2-32 characters long") 
	private String firstName;

	private String middleName;

	@NotBlank(message = "Need last name")
	private String lastName;

	@NotBlank(message = "Need to specify ssn")
	//@Size(min = 11, max = 11, message = "Not a valid SSN") 
	private String ssn;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL )
	@MapsId
	@JoinColumn(name = "account_id")
	private AccountHoldersContactDetails ahContact;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "account_id")
	private List<CheckingAccount> checkingAccounts;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "account_id")
	private List<SavingsAccount> savingsAccount;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "account_id")
	private List<CDAccount> cdAccounts;
	
	
	//private List<CheckingAccount> checkingAccounts = new ArrayList<CheckingAccount>();
//	private List<SavingsAccount> savingsAccounts = new ArrayList<SavingsAccount>();
	//private List<CDAccount> cdAccounts = new ArrayList<CDAccount>();
	
	//private  int numberOfCheckingAccounts ;
	//private double checkingBalance;
	//private  int numberOfSavingsAccounts;
	//private double savingsBalance;
	//private  int numberOfCDAccounts ;
	//private double cdBalance;
	
	//@Min(value = 0L) 
	//@Max(value = 250000, message = "Over 250k")
	//double combinedBalance;

	public List<CDAccount> getCdAccounts() {
		return cdAccounts;
	}



	public void setCdAccounts(List<CDAccount> cdAccounts) {
		this.cdAccounts = cdAccounts;
	}



	public List<SavingsAccount> getSavingsAccount() {
		return savingsAccount;
	}



	public void setSavingsAccount(List<SavingsAccount> savingsAccount) {
		this.savingsAccount = savingsAccount;
	}



	public List<CheckingAccount> getCheckingAccounts() {
		return checkingAccounts;
	}



	public void setCheckingAccounts(List<CheckingAccount> checkingAccounts) {
		this.checkingAccounts = checkingAccounts;
	}



	public AccountHoldersContactDetails getAhContact() {
		return ahContact;
	}



	public void setAhContact(AccountHoldersContactDetails ahContact) {
		this.ahContact = ahContact;
	}



	public AccountHolder() {
		
		this.firstName = "";
		this.middleName = "";
		this.lastName = "";
		this.ssn = "";
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/*public CheckingAccount addCheckingAccount(double balance) {
	
		CheckingAccount checkingAccount = new CheckingAccount(balance);
		return checkingAccount;
	}

	public void addCheckingAccount(CheckingAccount checkingAccount) {
		checkingAccounts.add(checkingAccount);
		
	}

	public List<CheckingAccount> getCheckingAccounts() {
		return checkingAccounts;
	}

	public SavingsAccount addSavingsAccount(double balance) {
		SavingsAccount savingsAccount = new SavingsAccount(balance);
		return savingsAccount;
	}

	public void addSavingsAccount(SavingsAccount savingsAccount) {
		savingsAccounts.add(savingsAccount);
		
	}
	public List<SavingsAccount> getSavingsAccounts() {
		return savingsAccounts;
	}
	
	public void addCDAccounts(CDAccount cdAccount) {
		cdAccounts.add(cdAccount);
	}
	
	
	public List<CDAccount> getCdAccounts() {
		return cdAccounts;
	}
	
	
	

	public  double getCheckingBalance() {
		checkingBalance = 0;
		for(CheckingAccount cB : checkingAccounts) {
			checkingBalance += cB.getBalance();
		}
		return checkingBalance;
	}
	
	public double getSavingsBalance() {
		savingsBalance =0;
		for(SavingsAccount sB: savingsAccounts) {
			savingsBalance += sB.getBalance();
		}
		return savingsBalance;
	}
	public double getCDBalance() {
		cdBalance = 0;
		for(CDAccount cdA: cdAccounts) {
			cdBalance += cdA.getBalance();
		}
		return cdBalance;
	}
	
	public int getNumberOfCheckingAccounts() {
		return checkingAccounts.size();
	}

	public int getNumberOfSavingsAccounts() {
		return savingsAccounts.size();
	}

	public int getNumberOfCDAccounts() {
		return  cdAccounts.size();
	}

	public double getCombinedBalance() 
	{
		this.combinedBalance	= getCheckingBalance()+ getSavingsBalance() + getCDBalance();
		return combinedBalance;
	}
*/

}
