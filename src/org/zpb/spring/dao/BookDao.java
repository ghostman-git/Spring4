package org.zpb.spring.dao;


public interface BookDao {
	public abstract Double queryPrice(String bid);
	public abstract int updatePrice(Double price, String bid);
	public abstract int updateCurrPrice(String bid);
}
