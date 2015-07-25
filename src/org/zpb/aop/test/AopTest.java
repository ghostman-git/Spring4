package org.zpb.aop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zpb.aop.service.Calculator;

public class AopTest {
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	private Calculator calculator = context.getBean(Calculator.class);
	
	//private Calculator calculator = new CalculatorImpl();
	//private Calculator proxy = this.calculator = new LoggingProxy(calculator).getLoggingProxy();
	
	@Test
	public void testService() {
		//System.out.println(this.proxy.add(3, 4));
		
		//System.out.println(this.calculator.add(2, 4));
		//System.out.println(this.calculator.sub(2, 4));
		
		System.out.println(this.calculator.div(4, 2));
		System.out.println(this.calculator.div(4, 0));
	}
}
