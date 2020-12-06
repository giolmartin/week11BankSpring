package com.meritamerica.week11.controller;

import java.util.*;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.meritamerica.week11.models.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
	
	public CheckingAccount addCheckingAccount(@PathVariable("id") int id, @RequestBody @Valid CheckingAccount checkingAccount) 
												throws NoSuchResourceFoundException{
		if( id > MeritBank.getAccountLength() ) {
			log.warn("Invalid ID");
			throw new NoSuchResourceFoundException("Invalid ID");
		}
		MeritBank.getAccountHolders().get(id-1).addCheckingAccount(checkingAccount);
		return checkingAccount;	
	}
	
	@GetMapping (value = "/AccountHolder/{id}/CheckingAccounts")
	public List<CheckingAccount> getCheckingAccounts(@PathVariable("id") int id ) throws NoSuchResourceFoundException{
		if( id > MeritBank.getAccountLength() ) {
			log.warn("Invalid ID");
			throw new NoSuchResourceFoundException("Invalid ID");
		}
		log.info("Checking Accounts returned");
		return MeritBank.getAccountHolders().get(id-1).getCheckingAccounts();
		
	}
	
	@PostMapping(value = "/AccountHolder/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount addSavingsAccount(@PathVariable("id") int id, @RequestBody @Valid SavingsAccount savingsAccount )
										throws NoSuchResourceFoundException{
		if( id > MeritBank.getAccountLength() ) {
			log.warn("Invalid ID");
			throw new NoSuchResourceFoundException("Invalid ID");
		}
		MeritBank.getAccountHolders().get(id-1).addSavingsAccount(savingsAccount);
		return savingsAccount;	
	}
	
	@GetMapping(value = "/AccountHolder/{id}/SavingsAccounts")
	public List<SavingsAccount> getSavingsAccounts(@PathVariable("id") int id) throws NoSuchResourceFoundException{
		if( id > MeritBank.getAccountLength() ) {
			log.warn("Invalid ID");
			throw new NoSuchResourceFoundException("Invalid ID");
		}
		log.info("Savings Accounts returned");
		return MeritBank.getAccountHolders().get(id-1).getSavingsAccounts();
	}
	
	@GetMapping(value = "/CDOfferings")
	public List<CDOffering> getCDOffering() {
		log.info("Returned account holders");
		return MeritBank.getCdOfferings();
		
	}
	
	@PostMapping(value = "/CDOfferings")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOffering addCDOffering(@RequestBody @Valid CDOffering cdOffering) {
		MeritBank.addCDOffering(cdOffering);
		log.info("cdOffering created and added");
		return cdOffering;
	}
	
	@PostMapping(value = "/AccountHolder/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount addCDAccount(@PathVariable("id") int id, @RequestBody @Valid CDAccount cdAccount) throws NoSuchResourceFoundException {
		if( id > MeritBank.getAccountLength() ) {
			log.warn("Invalid ID");
			throw new NoSuchResourceFoundException("Invalid ID");
		}
		MeritBank.getAccountHolders().get(id-1).addCDAccounts(cdAccount);
		return cdAccount;
	}
	
	@GetMapping(value = "/AccountHolder/{id}/CDAccounts")
	public List<CDAccount> getCDAccounts(@PathVariable ("id") int id) throws NoSuchResourceFoundException{
		if( id > MeritBank.getAccountLength() ) {
			log.warn("Invalid ID");
			throw new NoSuchResourceFoundException("Invalid ID");
		}
		return MeritBank.getAccountHolders().get(id-1).getCdAccounts();
	}
	
	
	
	
	
	
}
