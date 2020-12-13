package com.meritamerica.week11.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.week11.models.CheckingAccount;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Integer> {

}
