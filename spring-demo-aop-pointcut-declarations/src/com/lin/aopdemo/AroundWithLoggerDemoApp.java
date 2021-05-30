package com.lin.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lin.aopdemo.dao.AccountDAO;
import com.lin.aopdemo.dao.MembershipDAO;
import com.lin.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	
	public static Logger myLogger = 
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService trafficFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		
		myLogger.info("\n\n Main Program: AroundDemoApp");

		// get membership bean from spring container
		
		myLogger.info("call getFortune");

		try {
			trafficFortuneService.getFortune();
		} catch (Exception exe) {
			myLogger.info("\nMain Program: " + exe.toString());
		}
		
		myLogger.info("\n\nEnd Program: AroundDemoApp");
		myLogger.info("----------");


		// close the context
		context.close();
	}

}










