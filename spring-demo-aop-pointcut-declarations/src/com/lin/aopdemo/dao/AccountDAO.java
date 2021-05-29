package com.lin.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lin.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;

	public void addAccount(Account theAccount) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT" + theAccount);
		
	}
	
    public void addAccount(Account theAccount, boolean isTrue) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT" + theAccount);
		
	}
    
    public void doSomething() {
		
		System.out.println(getClass() + ": DOING SOMETHING");
		
	}

	public String getName() {
		System.out.println(getClass() + ": in getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in getName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode");
		this.serviceCode = serviceCode;
	}
	
	public List<Account> findAccounts() {
		
		List<Account> myAccounts = new ArrayList<Account>();
		
		Account temp1 = new Account("test1", "Lv1");
		Account temp2 = new Account("test2", "Lv2");
		Account temp3 = new Account("test3", "Lv3");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
        
		return myAccounts;
		
	}
    
    
}
