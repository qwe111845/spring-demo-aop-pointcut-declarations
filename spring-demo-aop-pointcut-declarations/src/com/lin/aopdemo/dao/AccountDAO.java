package com.lin.aopdemo.dao;

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
    
    
}
