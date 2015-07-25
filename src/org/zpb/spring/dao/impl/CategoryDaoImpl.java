package org.zpb.spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.zpb.spring.domain.Category;

@Repository
public class CategoryDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Category getCategory(String cid) {
		String sql = "select * from `t_category` where `cid`=?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Category>(Category.class), "1");
	}
	
}
