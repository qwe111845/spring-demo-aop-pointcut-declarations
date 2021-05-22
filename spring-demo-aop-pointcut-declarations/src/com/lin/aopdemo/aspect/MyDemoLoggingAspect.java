  package com.lin.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	// reuse a pointcut expression
	@Pointcut("execution(* com.lin.aopdemo.*.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.lin.aopdemo.*.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(* com.lin.aopdemo.*.*.set*(..))")
	private void setter() {}
	
	@Pointcut("forDaoPackage && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	
	
	// let's start with an @Before advice

	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on method");
		
	}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvicePackage() {
		
		System.out.println("\n=====>>> Executing @Before advice on package method");
		
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		
		System.out.println("=====>>> Performing API analytics");
		
	}
}










