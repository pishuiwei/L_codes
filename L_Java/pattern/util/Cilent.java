package util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import dynamicProxy.AbstractSubject;
import dynamicProxy.DynamicProxy;
import dynamicProxy.RealSubjectA;
import dynamicProxy.RealSubjectB;

public class Cilent {

	public static void main(String[] args) {
		//工厂方法模式
//		TVFactory tvFactory = (TVFactory) XMLUtil.getBean();
//		TV tv = tvFactory.produceTV();
//		tv.play();
		
		// 抽象工厂方法
//		EFactory factory = (EFactory) XMLUtil.getBean();
//		Television television = factory.produceTelevision();
//		AirConditioner airConditioner = factory.produceAirConditioner();
//		television.play();
//		airConditioner.changeTemperature();
		
		InvocationHandler handler = null;
		AbstractSubject subject = null;
		
		handler = new DynamicProxy(new RealSubjectA());
		/**
		 * loader 代表类的类加载器
		 * interfaces 表示代理实现的接口列表（与真实主题类的接口列表一致）
		 * h 表示所指派的调用处理程序类
		 * 
		 */
		subject = (AbstractSubject) Proxy.newProxyInstance(AbstractSubject.class.getClassLoader(),new Class[] {AbstractSubject.class}, handler);
		subject.request();
		
		System.out.println("------------------------");
		
		handler = new DynamicProxy(new RealSubjectB());
		subject = (AbstractSubject) Proxy.newProxyInstance(AbstractSubject.class.getClassLoader(),new Class[] {AbstractSubject.class}, handler);
		subject.request();
		
	}
	
}
