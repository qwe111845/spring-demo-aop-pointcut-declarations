package com.lin.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lin.aopdemo.dao.AccountDAO;
import com.lin.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from spring container
		MembershipDAO theMembershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
		Account theAccount = new Account();
				
		// call the business method
		theAccountDAO.addAccount(theAccount);
		theAccountDAO.doSomething();

		// call the membership business method
		theMembershipDAO.add();
						
		// close the context
		context.close();
	}

}










