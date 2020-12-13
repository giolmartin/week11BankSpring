package com.meritamerica.week11.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.week11.models.AccountHolder;



public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer> {

	AccountHolder findByFirstName(String name);

}
