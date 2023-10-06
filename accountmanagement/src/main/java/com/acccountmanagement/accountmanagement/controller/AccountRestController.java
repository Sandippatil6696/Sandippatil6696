package com.acccountmanagement.accountmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acccountmanagement.accountmanagement.model.Account;
import com.acccountmanagement.accountmanagement.service.AccountService;


@RestController
//@RequestMapping("/account")
public class AccountRestController {
	
	@Autowired
	private AccountService accountservice;
	
   //for add account & update 
	@PostMapping("account/add")
	public Account addFAculty(@RequestBody Account a) {
		return accountservice.saveAcount(a);
	}
	
  //for getting list
	@GetMapping("account/all")
	public List<Account> getAccountList(){
		 return accountservice.getlist();
	}
	
//	for delete account by id
	@DeleteMapping("account/{id}")
	public List <Account> deleteById(@PathVariable("id") Integer id) {
		return accountservice.deleteAccountbyid(id);
		}

}
