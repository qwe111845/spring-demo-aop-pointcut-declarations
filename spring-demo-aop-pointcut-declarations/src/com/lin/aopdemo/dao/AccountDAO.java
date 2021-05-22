package com.lin.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.lin.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT" + theAccount);
		
	}
	
    public void addAccount(Account theAccount, boolean isTrue) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT" + theAccount);
		
	}
    
    public void doSomething() {
		
		System.out.println(getClass() + ": DOING SOMETHING");
		
	}
}
