package org.zpb.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zpb.spring.dao.BookDao;
import org.zpb.spring.service.BookService;

public class TXTest {
	private static ApplicationContext context;
	private static BookDao bookDao;
	private static BookService bookService;
	
	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookDao = context.getBean(BookDao.class);
		bookService = context.getBean(BookService.class);
	}
	
	private static void testService() {
		bookService.modifyPrice(40.00, "000A18FDB38F470DBE9CD0972BADB23F");
	}
	
	private static Double getPrice() {
		return bookDao.queryPrice("000A18FDB38F470DBE9CD0972BADB23F");
	}
	
	private static int modifyPrice() throws Exception {
		return bookDao.updatePrice(88.9, "000A18FDB38F470DBE9CD0972BADB23F");
	}
	
	public static void main(String[] args) {
//		System.out.println(modifyPrice());
//		System.out.println(getPrice());
		
		testService();
	}
}
