package org.zpb.xml.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.zpb.xml.dao.BookDao;
import org.zpb.spring.service.impl.UserException;

public class BookDaoImpl implements BookDao {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
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
