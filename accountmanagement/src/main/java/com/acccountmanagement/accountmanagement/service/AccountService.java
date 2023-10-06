package com.acccountmanagement.accountmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acccountmanagement.accountmanagement.model.Account;
import com.acccountmanagement.accountmanagement.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired  
	private AccountRepository accountrepository;
	
//	for adding  and update
	public Account saveAcount(Account a){
		return accountrepository.save(a);
	}
	
//	for getting list
	
	public List<Account> getlist(){
		return accountrepository.findAll();
	}
	
//	for delete account
	public List <Account> deleteAccountbyid(Integer id ){
		accountrepository.deleteById(id);
		return getlist();
	}
	

}
