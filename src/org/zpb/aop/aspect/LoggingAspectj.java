package org.zpb.aop.aspect;

import java.util.Arrays;
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
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1) // 值越小优先级越高
public class LoggingAspectj {
	
	@Pointcut("execution(* org.zpb.aop.service.*.*(..))")
	public void log(){}
	
	/**
	 * 前置通知（在方法执行之前执行）
	 * @param point
	 */
	//@Before("execution(public int org.zpb.aop.service.Calculator.*(int, int))")
	//@Before("execution(* org.zpb.aop.service.*.*(..))")
	@Before("log()")
	public void beforeMethod(JoinPoint point) {
		String methodName = point.getSignature().getName();
		List<Object> params = Arrays.asList(point.getArgs());
		
		System.out.println("前置通知[方法："+methodName+"("+params+")]");
	}
	
	/**
	 * 后置通知（在方法执行之后执行，无论是否发生异常都会执行）
	 * @param point
	 */
	//@After("execution(* *.*(..))")
	@After("log()")
	public void afterMethod(JoinPoint point) {
		String methodName = point.getSignature().getName();
		List<Object> params = Arrays.asList(point.getArgs());
		
		System.out.println("后置通知[方法："+methodName+"("+params+")]");
	}
	
	/**
	 * 在方法执行后执行，会返回执行结果
	 * @param point
	 * @param result
	 */
	@AfterReturning(value="log()",returning="result")
	public void afterReturning(JoinPoint point, Object result) {
		String methodName = point.getSignature().getName();
		List<Object> params = Arrays.asList(point.getArgs());
		
		System.out.println("后置返回通知[方法："+methodName+"("+params+")],结果："+result);
	}
	
	/**
	 * 异常通知
	 * @param point
	 * @param exc
	 */
	@AfterThrowing(value="log()",throwing="exc")
	public void afterReturning(JoinPoint point, Exception exc) {
		String methodName = point.getSignature().getName();
		List<Object> params = Arrays.asList(point.getArgs());
		
		System.out.println("后置返回通知[方法："+methodName+"("+params+")],异常："+exc);
	}
	
	/**
	 * 环绕通知
	 * @param point
	 */
	@Around("log()")
	public Object aroundMethod(ProceedingJoinPoint point) {
		String methodName = point.getSignature().getName();
		List<Object> params = Arrays.asList(point.getArgs());
		Object result = null;
		
		try {
			System.out.println("环绕通知-前置通知[方法："+methodName+"("+params+")]");
			result = point.proceed();
			System.out.println("环绕通知-返回通知[方法："+methodName+"("+params+"),结果："+result+"]");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("环绕通知-异常通知[方法："+methodName+"("+params+"),异常："+e+"]");
			throw new RuntimeException(e);
		}
		System.out.println("环绕通知-后置通知[方法："+methodName+"]");
		return result;
	}
}
