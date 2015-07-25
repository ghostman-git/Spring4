package org.zpb.xml.service.impl;

import org.zpb.xml.dao.BookDao;
import org.zpb.xml.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public void modifyPrice(Double price, String bid) {
		// TODO Auto-generated method stub
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		bookDao.updatePrice(price, bid);
		bookDao.updateCurrPrice(bid);
	}

}
