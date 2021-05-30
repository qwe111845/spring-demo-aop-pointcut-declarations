package com.lin.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lin.aopdemo.dao.AccountDAO;
import com.lin.aopdemo.dao.MembershipDAO;
import com.lin.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService trafficFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		
		System.out.println("\n\n Main Program: AroundDemoApp");

		// get membership bean from spring container
		
		System.out.println("call getFortune");

		try {
			trafficFortuneService.getFortune();
		} catch (Exception exe) {
			System.out.println("\nMain Program: " + exe.toString());
		}
		
		System.out.println("\n\nEnd Program: AroundDemoApp");
		System.out.println("----------");


		// close the context
		context.close();
	}

}










