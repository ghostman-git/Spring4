package org.zpb.aop.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zpb.aop.service.Calculator;

@Service
@Transactional
public class CalculatorImpl implements Calculator {

	@Override
	public int add(int i, int j) {
		// TODO Auto-generated method stub
		return (i + j);
	}

	@Override
	public int sub(int i, int j) {
		// TODO Auto-generated method stub
		return (i - j);
	}

	@Override
	public int mul(int i, int j) {
		// TODO Auto-generated method stub
		return (i * j);
	}

	@Override
	public int div(int i, int j) {
		// TODO Auto-generated method stub
		return (i / j);
	}

}
