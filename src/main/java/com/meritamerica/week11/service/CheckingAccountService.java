package com.meritamerica.week11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.week11.models.CheckingAccount;
import com.meritamerica.week11.repository.CheckingAccountRepository;

@Service
public class CheckingAccountService {
	
	@Autowired
	private CheckingAccountRepository repository;

	public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
		return repository.save(checkingAccount);
	}
	
	public List<CheckingAccount> getCheckingAccounts(){
		return repository.findAll();
	}
}
