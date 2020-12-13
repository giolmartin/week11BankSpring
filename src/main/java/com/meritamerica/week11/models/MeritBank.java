package com.meritamerica.week11.models;

import java.util.*;

public class MeritBank {

	private static List<AccountHolder> accounts = new ArrayList<AccountHolder>();
	private static List<CDOffering> cdOfferings = new ArrayList<CDOffering>();
	private static  int accountNumber = 1;
	
	public static  void addAccountHolder(AccountHolder accountHolder) 
	{
		accounts.add(accountHolder);	
	}

	public static List<AccountHolder> getAccountHolders() 
	{
		return accounts;
	}
	public static int getAccountLength() {
		return accounts.size();
	}
	
	public  static int getNextAccountNumber() 
	{
		return accountNumber++ ;
	}
	
	public static int getAccountNumber() {
		return accountNumber;
	}
	
	public static void addCDOffering(CDOffering cdOffering) {
		cdOfferings.add(cdOffering);
	}
	public static List<CDOffering> getCdOfferings() {
		return cdOfferings;
	}

	public static void setCdOfferings(List<CDOffering> cdOfferings) {
		MeritBank.cdOfferings = cdOfferings;
	}

	
}
