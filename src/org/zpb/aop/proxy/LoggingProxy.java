package org.zpb.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.zpb.aop.service.Calculator;

public class LoggingProxy {
	// 要代理的对象
	private Calculator target;

	public LoggingProxy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoggingProxy(Calculator target) {
		super();
		this.target = target;
	}

	public Calculator getLoggingProxy() {
		Calculator proxy = null;
		// 代理对象由哪一个类加载器负责加载
		ClassLoader loader = this.target.getClass().getClassLoader();
		// 代理对象的类型，即其中有哪些方法
		Class[] interfaces = new Class[] { Calculator.class };
		// 当调用代理对象其中的方法时，该执行的代码
		InvocationHandler handler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				System.out.println(method.getName()+"开始");
				Object result = method.invoke(target, args);
				System.out.println(method.getName()+"结束");
				return result;
			}
		};
		proxy = (Calculator) Proxy.newProxyInstance(loader, interfaces, handler);
		return proxy;
	}
}
