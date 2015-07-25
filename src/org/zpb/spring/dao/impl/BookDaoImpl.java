package org.zpb.spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.zpb.spring.dao.BookDao;
import org.zpb.spring.service.impl.UserException;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Double queryPrice(String bid) {
		// TODO Auto-generated method stub
		String sql = "select `price` from `t_book` where `bid`=?";
		return jdbcTemplate.queryForObject(sql, Double.class, bid);
	}

	@Override
	public int updatePrice(Double price, String bid) {
		// TODO Auto-generated method stub
		Double p = queryPrice(bid);
		if(p<60.00) throw new UserException("小于60");
		String sql = "update `t_book` set `price`=? where `bid`=?";
		return jdbcTemplate.update(sql, price, bid);
	}

	@Override
	public int updateCurrPrice(String bid) {
		// TODO Auto-generated method stub
		String sql = "update `t_book` set `currPrice`=`currPrice`+100 where `bid`=?";
		return jdbcTemplate.update(sql, bid);
	}

}
