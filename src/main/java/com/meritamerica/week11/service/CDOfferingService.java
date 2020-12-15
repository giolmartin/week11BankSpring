package com.meritamerica.week11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.week11.models.CDOffering;
import com.meritamerica.week11.repository.CDOfferingRepository;

@Service
public class CDOfferingService {
	
	@Autowired
	CDOfferingRepository repository;
	
	public CDOffering addCDOffering(CDOffering cdOffering) {
		return repository.save(cdOffering);
	}
	
	public List<CDOffering> getCDOfferings(){
		return repository.findAll();
	}
}
