  package com.lin.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.lin.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyLoggingDemoAspect {
	
	@Around("execution(* com.lin.aopdemo.service.*.*(..))")
	public Object aroundFindAccountsAdvice(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n========> Excuting @Around on method: " + method);
		
		// get begin time stamp
		long begin = System.currentTimeMillis();
		
		// execute the method
		Object result = theProceedingJoinPoint.proceed();
		
		// end time stamp
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		System.out.println("\n========> Duration: " + duration / 1000.0 + " seconds");
		
		return result;
						
	}
	
	// add a new advice for @AfterReturning on the findAccounts method
	
	@AfterReturning(
			pointcut="execution(* com.lin.aopdemo.dao.AccountDAO.findAccounts(..))", 
			returning="result")
	public void afterFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========> Excuting @AfterReturning on method: " + method);
		
		System.out.println("Result is:" + result); 
		
		
		convertAccountNamesToUpperCase(result);
		
	}
	
	
	@AfterThrowing(
			pointcut="execution(* com.lin.aopdemo.dao.AccountDAO.findAccounts(..))", 
			throwing="theException")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theException) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========> Excuting @AfterThrowing on method: " + method);
		
		System.out.println("Exception is: " + theException);
				
	}
	
	@After("execution(* com.lin.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========> Excuting @After on method: " + method);
						
	}

	// let's start with an @Before advice

	@Before("com.lin.aopdemo.aspect.LinAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n=====>>> Executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		Object[] args = theJoinPoint.getArgs();
		
		for (Object tempArg: args) {
			System.out.print(tempArg + " ");
			
			if (tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				
				System.out.println("\n" + theAccount.getName());
				
			}
		}
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for(Account tempAccount: result) {
			
			String theUpperName = tempAccount.getName().toUpperCase();
			
			// update the acount name to uppercase
			tempAccount.setName(theUpperName);
		}
        		
	}

}










