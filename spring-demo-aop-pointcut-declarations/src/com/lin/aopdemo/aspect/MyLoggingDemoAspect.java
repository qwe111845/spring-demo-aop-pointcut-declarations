  package com.lin.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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

}










