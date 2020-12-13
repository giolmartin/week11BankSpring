package com.meritamerica.week11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.week11.models.AccountHoldersContactDetails;
import com.meritamerica.week11.repository.AccountHoldersContactDetailsRepository;

@Service
public class AccountHoldersContactDetailsService {

	@Autowired
	 private AccountHoldersContactDetailsRepository repository;
	
	public AccountHoldersContactDetails addContactDetails(AccountHoldersContactDetails ahContact) {
		return repository.save(ahContact);
	}
	
	
	
}
