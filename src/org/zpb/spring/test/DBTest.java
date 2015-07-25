package org.zpb.spring.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.zpb.spring.domain.Category;
import org.zpb.spring.domain.User;

public class DBTest {

	private static ApplicationContext context;
	private static JdbcTemplate jdbcTemplate;
	
	private static NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		
		namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) context.getBean("namedParameterJdbcTemplate");
	}
	
	private static int testNamedParameterJdbcTemplate2() {
		String sql = "insert into `t_user`(`uid`,`loginname`,`email`) values(:uid,:loginname,:email)";
		User user = new User();
		user.setUid("ZZjjdjf3j3k34j3k4j");
		user.setLoginname("xiaoxiao_");
		user.setEmail("924370973@zpb.com");
		return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(user));
	}
	
	private static int testNamedParameterJdbcTemplate() {
		String sql = "insert into `t_user`(`uid`,`loginname`,`email`) values(:uid,:name,:email)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("uid", "jjdjf3j3k34j3k4j");
		paramMap.put("name", "xiaoxiao");
		paramMap.put("email", "924370973@qq.com");
		paramMap.put("uid", "852369741");
		paramMap.put("name", "xiaoxiao1");
		paramMap.put("email", "2224370973@qq.com");
		return namedParameterJdbcTemplate.update(sql, paramMap);
	}
	
	private static int testUpdate() {
		String sql = "update `t_user` set `email`=? where `loginname`=?";
		return jdbcTemplate.update(sql, "zpb_wm@126.com", "zhouzhou");
	}
	
	/**
	 * 执行批量操作
	 * @param args
	 */
	private static int[] testBatchUpdate() {
		String sql = "insert into `t_user`(`loginname`,`uid`,`email`) values(?,?,?)";
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[] {"xiaomiao","123q","zpb_wm1@163.com"});
		batchArgs.add(new Object[] {"xiaojing","123w","zpb_wm2@163.com"});
		batchArgs.add(new Object[] {"xiaoyong","123x","zpb_wm3@163.com"});
		batchArgs.add(new Object[] {"xiaoyan","123vc","zpb_wm4@163.com"});
		batchArgs.add(new Object[] {"xiaosun","123dx","zpb_wm5@163.com"});
		batchArgs.add(new Object[] {"xiaoguo","123f","zpb_wm6@163.com"});
		return jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	
	private static Category queryObject() {
		//String sql = "select * from `t_category` where `cid`=?";
		/*
		 * jdbcTemplate是一个JDBC小工具，而不是ORM框架
		 */
		String sql = "select `pid` as \"category.cid\" from `t_category` where `cid`=?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Category>(Category.class), "1");
	}
	
	private static List<Category> queryList() {
		String sql = "select * from `t_category` where 1";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
	}
	
	private static int queryCounts() {
		String sql = "select count(*) from `t_category` where 1";
		return jdbcTemplate.queryForObject(sql, Number.class).intValue();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		DataSource dataSource = context.getBean(DataSource.class);
//		System.out.println("[dataSource]"+dataSource);
		/*
		 * 1
		 */
		//testUpdate();
		/*
		 * 2
		 */
		//System.out.println(testBatchUpdate());
		/*
		 * 3
		 */
		//System.out.println(queryObject());
		/*
		 * 4
		 */
		//System.out.println(queryList());
		/*
		 * 5
		 */
		//System.out.println(queryCounts());
		
		/*
		 * 6
		 */
		//System.out.println(testNamedParameterJdbcTemplate());
		
		/*
		 * 7
		 */
		testNamedParameterJdbcTemplate2();
	}

}
