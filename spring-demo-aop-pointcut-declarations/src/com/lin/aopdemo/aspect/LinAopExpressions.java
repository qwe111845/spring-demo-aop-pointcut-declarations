package com.lin.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LinAopExpressions {
	
	// reuse a pointcut expression
	@Pointcut("execution(* com.lin.aopdemo.*.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.lin.aopdemo.*.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.lin.aopdemo.*.*.set*(..))")
	public void setter() {}
	
	// combine pointcut with && || ! 
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	
}
