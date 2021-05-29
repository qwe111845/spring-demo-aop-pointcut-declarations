package com.lin.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lin.aopdemo.dao.AccountDAO;
import com.lin.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from spring container
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		System.out.println("\n\n Main Program:AfterReturningDemoApp");
		System.out.println("----------");

		System.out.println(theAccounts);

		// close the context
		context.close();
	}

}










