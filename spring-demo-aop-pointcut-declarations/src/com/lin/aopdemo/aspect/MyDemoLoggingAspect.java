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
	@Pointcut("execution(* com.lin.aopdemo.c.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.lin.aopdemo.c.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(* com.lin.aopdemo.c.*.set*(..))")
	private void setter() {}
	
	// combine pointcut with && || ! 
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	
	
	// let's start with an @Before advice

	@Before("com.lin.aopdemo.aspect.MyDemoLoggingAspect.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on method");
		
	}
	
	@Before("com.lin.aopdemo.aspect.MyDemoLoggingAspect.forDaoPackage()")
	public void beforeAddAccountAdvicePackage() {
		
		System.out.println("\n=====>>> Executing @Before advice on package method");
		
	}
	

	

}










