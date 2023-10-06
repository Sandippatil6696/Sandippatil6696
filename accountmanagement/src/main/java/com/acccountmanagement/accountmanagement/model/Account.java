package com.acccountmanagement.accountmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account_management_system")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String accountname;
	
	@Column
	private Integer balance;
	
	
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Account(Integer id, String accountname, Integer balance) {
		super();
		this.id = id;
		this.accountname = accountname;
		this.balance = balance;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getAccountname() {
		return accountname;
	}


	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}


	public Integer getBalance() {
		return balance;
	}


	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
	

}
