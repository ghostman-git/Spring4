package org.zpb.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.zpb.spring.dao.BookDao;
import org.zpb.spring.service.BookService;

@Repository("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	/* 1
	 * 使用propagation指定事务的传播行为
	 * REQUIRED 使用之前的事务(non-Javadoc)
	 * REQUIRES_NEW 开启一个新事务
	 */
	/*
	 * 2
	 * isolation指定事务的隔离级别
	 * READ_COMMITTED读已提交(最常用)
	 */
	/*
	 * 3
	 * noRollbackFor 对异常不进行回滚
	 */
	/*
	 * 4
	 * readOnly只读属性
	 * 表示这个事务只读取数据但不更新数据，可以帮助数据库引擎优化事务
	 */
	/*
	 * 5
	 * timeout 指定强制回滚之前事务可以占用的时间(单位：秒)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, 
					isolation = Isolation.READ_COMMITTED, 
					noRollbackFor = { UserException.class }, 
					readOnly =true, 
					timeout=3)
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
