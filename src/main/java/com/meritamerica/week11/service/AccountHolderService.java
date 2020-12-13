package com.meritamerica.week11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.week11.models.AccountHolder;
import com.meritamerica.week11.repository.AccountHolderRepository;

@Service
public class AccountHolderService {

	@Autowired
	private AccountHolderRepository repository;
	
	public AccountHolder addAccountHolder(AccountHolder accountHolder) {
		return repository.save(accountHolder);
	}
	
	public List<AccountHolder> addAccountHolders(List<AccountHolder> accountHolders) {
		return repository.saveAll(accountHolders);
	}
	
	public List<AccountHolder> getAccountHolders(){
		return repository.findAll();
	}
	
	public AccountHolder getAccountById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public AccountHolder getAccountByName(String name) {
		return repository.findByFirstName(name);
	}
	
	public String deleteAccountHolder(int id) {
		repository.deleteById(id);
		return "Account Holder removed. " + id;
	}
	
	public AccountHolder updateAccount(AccountHolder accountHolder) {
		AccountHolder existingAccount = repository.findById(accountHolder.getId()).orElse(null);
		existingAccount.setFirstName(accountHolder.getFirstName());
		existingAccount.setLastName(accountHolder.getLastName());
		return repository.save(existingAccount);
	}
}
