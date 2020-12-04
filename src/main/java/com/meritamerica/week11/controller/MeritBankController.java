package com.meritamerica.week11.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.meritamerica.week11.models.*;



@RestController
@Validated
public class MeritBankController {

	
	@GetMapping(value = "/AccountHolder")
	public List<AccountHolder> getAccountHolder() {
		return MeritBank.getAccountHolders();
	}
	
	@PostMapping(value = "/AccountHolder")
	@ResponseStatus(HttpStatus.CREATED)
	public  AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {
		MeritBank.addAccountHolder(accountHolder);
		return accountHolder;
	}
	
	
	
}
