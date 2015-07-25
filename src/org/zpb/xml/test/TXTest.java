package org.zpb.xml.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zpb.xml.service.BookService;

public class TXTest {
	private static ApplicationContext context;
	private static BookService bookService;
	
	static {
		context = new ClassPathXmlApplicationContext("applicationContext_xml.xml");
		bookService = context.getBean(BookService.class);
	}
	
	private static void testService() {
		bookService.modifyPrice(40.00, "000A18FDB38F470DBE9CD0972BADB23F");
	}
	
	public static void main(String[] args) {
		testService();
	}
}
