package com.meritamerica.week11.controller;

import java.util.*;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.meritamerica.week11.models.*;
import com.meritamerica.week11.service.AccountHolderService;
import com.meritamerica.week11.service.AccountHoldersContactDetailsService;
import com.meritamerica.week11.service.CDOfferingService;
import com.meritamerica.week11.service.CheckingAccountService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.meritamerica.week11.exceptions.*;

@Repository
@Transactional
@RestController
@Validated
public class MeritBankController {
	private static final double  MAX_COMBINED_AMOUNT= 250000;

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AccountHolderService ahService;
	
	@Autowired
	private AccountHoldersContactDetailsService ahContactService;
	
	@Autowired
	private CheckingAccountService cService;
	
	@Autowired
	private CDOfferingService cdOService;
	
	@GetMapping(value = "/AccountHolder")
	public List<AccountHolder> getAccountHolder() {
		log.info("Returned account holders");
		return ahService.getAccountHolders();
	}
	
	@PostMapping(value = "/addAccountHolder")
	@ResponseStatus(HttpStatus.CREATED)
	public  AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {
	
		log.info("User has added account");
	//	ahContactService.addContactDetails(ahContact);
		return ahService.addAccountHolder(accountHolder);
	
	}
	
	@PostMapping(value = "/contact/{id}")
	public AccountHoldersContactDetails addContacts( @PathVariable int id,@RequestBody AccountHoldersContactDetails ahContact ) throws NoSuchResourceFoundException {
		
		return ahContactService.addContactDetails(ahContact);
	}
	
	@GetMapping(value = "/AccountHolder/{id}")
	public AccountHolder getAccountByID(@PathVariable int id) throws NoSuchResourceFoundException {
		
		if( ahService.getAccountById(id) ==null) {
			log.warn("Invalid ID");
			throw new NoSuchResourceFoundException("Invalid ID");
		}
		log.info("Returned Account Holder");
		return ahService.getAccountById(id);
		}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return ahService.deleteAccountHolder(id);
	}
	
	 @PostMapping(value = "/AccountHolder/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	
	public CheckingAccount addCheckingAccount(@PathVariable int id, @RequestBody @Valid CheckingAccount checkingAccount) 
												throws NoSuchResourceFoundException, ExceedsCombinedLimitException{
		
	
	/*	if(ah.getCombinedBalance() + checkingAccount.getBalance() > MAX_COMBINED_AMOUNT) {
			log.warn("Combined Balance exceeds 250000");
			throw new ExceedsCombinedLimitException("Combined Balance exceeds 250000");
		}
		*/
		log.info("Checking Account created and Added");
		
		return cService.addCheckingAccount(checkingAccount);	
	}
	
	@GetMapping (value = "/checkingaccounts")
	public List<CheckingAccount> getCheckingAccounts() throws NoSuchResourceFoundException{
		
		log.info("Checking Accounts returned");
		return cService.getCheckingAccounts();
		
	}
	@PostMapping(value = "/addcdo")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOffering addCDOffering(@RequestBody @Valid CDOffering cdOffering) {
		
		log.info("cdOffering created and added");
		return cdOService.addCDOffering(cdOffering);
	}
	
	@GetMapping(value = "/cdo/all")
	public List<CDOffering> getCDOffering() {
		log.info("Returned account holders");
		return cdOService.getCDOfferings();
		
	}
	
	/*@PostMapping(value = "/AccountHolder/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount addSavingsAccount(@PathVariable("id") int id, @RequestBody @Valid SavingsAccount savingsAccount )
										throws NoSuchResourceFoundException, ExceedsCombinedLimitException{
		AccountHolder ah = getAccountByID(id);
		
		if(ah.getCombinedBalance() + savingsAccount.getBalance() > MAX_COMBINED_AMOUNT) {
			log.warn("Combined Balance exceeds 250000");
			throw new ExceedsCombinedLimitException("Combined Balance exceeds 250000");
		}
		log.info("Savings Account created and Added");
		ah.addSavingsAccount(savingsAccount);
		return savingsAccount;	
	}
	
	@GetMapping(value = "/AccountHolder/{id}/SavingsAccounts")
	public List<SavingsAccount> getSavingsAccounts(@PathVariable("id") int id) throws NoSuchResourceFoundException{
		AccountHolder ah = getAccountByID(id);
		log.info("Savings Accounts returned");
		return ah.getSavingsAccounts();
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
	public CDAccount addCDAccount(@PathVariable("id") int id, @RequestBody @Valid CDAccount cdAccount) throws NoSuchResourceFoundException, ExceedsCombinedLimitException {
		AccountHolder ah = getAccountByID(id);
		if(ah.getCombinedBalance() + cdAccount.getBalance() > MAX_COMBINED_AMOUNT) {
			log.warn("Combined Balance exceeds 250000");
			throw new ExceedsCombinedLimitException("Combined Balance exceeds 250000");
		}
		
		ah.addCDAccounts(cdAccount);
		log.info("CDAccount created and Added");
		return cdAccount;
	}
	
	@GetMapping(value = "/AccountHolder/{id}/CDAccounts")
	public List<CDAccount> getCDAccounts(@PathVariable ("id") int id) throws NoSuchResourceFoundException{
		AccountHolder ah = getAccountByID(id);
		return ah.getCdAccounts();
	}
	
	
	
	
	*/
	
}
