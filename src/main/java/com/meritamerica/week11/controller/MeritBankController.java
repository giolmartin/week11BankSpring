package com.meritamerica.week11.controller;

import java.util.*;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.meritamerica.week11.models.*;
import com.meritamerica.week11.exceptions.*;



@RestController
@Validated
public class MeritBankController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value = "/AccountHolder")
	public List<AccountHolder> getAccountHolder() {
		log.info("Returned account holders");
		return MeritBank.getAccountHolders();
		
	}
	
	@PostMapping(value = "/AccountHolder")
	@ResponseStatus(HttpStatus.CREATED)
	public  AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {
		//try catch here i think
		MeritBank.addAccountHolder(accountHolder);
		log.info("User has added account");
		return accountHolder;
	}
	@GetMapping(value = "/AccountHolder/{id}")
	public AccountHolder getAccountByID(@PathVariable int id) throws NoSuchResourceFoundException {
		
		if( id > MeritBank.getAccountLength() ) {
			log.warn("Invalid ID");
			throw new NoSuchResourceFoundException("Invalid ID");
		}
		log.info("Returned Account Holder");
		return MeritBank.getAccountHolders().get(id-1);
	}
	
	@PostMapping(value = "/AccountHolder/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount addCheckingAccount(@PathVariable("id") int id, @RequestBody CheckingAccount checkingAccount ) throws NoSuchResourceFoundException{
		if( id > MeritBank.getAccountLength() ) {
			log.warn("Invalid ID");
			throw new NoSuchResourceFoundException("Invalid ID");
		}
		//CheckingAccount acc = new CheckingAccount(b);
		MeritBank.getAccountHolders().get(id-1).addCheckingAccount(checkingAccount);
		return checkingAccount;
		
	}
	
	
	
	
}
