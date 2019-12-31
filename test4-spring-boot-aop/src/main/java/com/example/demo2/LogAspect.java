package com.example.demo2;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	
	@Pointcut("execution(* com.example.demo2.service.*.*(..))")
	//@Pointcut("execution(* org.sang.aop.     service.*.*(..))")
	public void pc1() {	
		System.out.println("pc1");
	}
	
	@Before(value="pc1()")
	public void before(JoinPoint jp) {
		String name = jp.getSignature().getName();
		System.out.println( name + "方法开始执行");
	}
	
	@After(value="pc1()")
	public void after(JoinPoint jp) {
		String name = jp.getSignature().getName();
		System.out.println(name + "方法执行结束");
		
	}
	//@AfterReturning(value="pc1()")
	@AfterReturning(value = "pc1()", returning = "result")
	public void afterReturning(JoinPoint jp,Object result) {
		String name = jp.getSignature().getName();
		System.out.println(name + "方法返回" + result);
	}

}
