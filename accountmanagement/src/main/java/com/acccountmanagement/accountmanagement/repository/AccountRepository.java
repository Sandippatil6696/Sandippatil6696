package com.acccountmanagement.accountmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acccountmanagement.accountmanagement.model.Account;

public interface AccountRepository  extends JpaRepository<Account, Integer>{

}
