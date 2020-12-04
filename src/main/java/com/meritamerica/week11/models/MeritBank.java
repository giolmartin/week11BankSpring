package com.meritamerica.week11.models;

import java.util.*;

public class MeritBank {

	private static List<AccountHolder> accounts = new ArrayList<AccountHolder>();
	
	public static  void addAccountHolder(AccountHolder accountHolder) 
	{
		accounts.add(accountHolder);	
	}

	public static List<AccountHolder> getAccountHolders() 
	{
		return accounts;
	}
	
}
