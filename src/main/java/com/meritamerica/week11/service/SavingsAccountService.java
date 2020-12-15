package com.meritamerica.week11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.week11.models.SavingsAccount;
import com.meritamerica.week11.repository.SavingsAccountRepository;

@Service
public class SavingsAccountService {
	
	@Autowired 
	private SavingsAccountRepository repository;

	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
		return repository.save(savingsAccount);
	}
	
	public List<SavingsAccount> getSavingsAccount(){
		return repository.findAll();
	}
}
