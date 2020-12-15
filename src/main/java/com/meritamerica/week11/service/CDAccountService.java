package com.meritamerica.week11.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.meritamerica.week11.repository.CDAccountRepository;

public class CDAccountService {

	@Autowired
	CDAccountRepository repository;
}
