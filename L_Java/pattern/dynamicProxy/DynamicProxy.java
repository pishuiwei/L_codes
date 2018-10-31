package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 动态代理类
 * @author PW 2018/04/01
 *
 */
public class DynamicProxy implements InvocationHandler{
	
	private Object obj;
	
	public DynamicProxy() {}
	
	public DynamicProxy(Object obj) {
		this.obj = obj;
	}
	
	/**
	 * 
	 * @param proxy 表示代理类
	 * @param method 表示需要代理的方法
	 * @param args 表示代理方法的参数数组
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		preRequest();
		method.invoke(obj, args);
		postRequest();
		return null;
	}
	
	public void preRequest() {
		System.out.println("调用之前!");
	}
	public void postRequest() {
		System.out.println("调用之后!");
	}
}


