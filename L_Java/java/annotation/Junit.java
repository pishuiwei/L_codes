package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Junit {
	//传入一个对象实例 
	public static void run(Class<?> c) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] methods = c.getDeclaredMethods();
		List<Method> testList = new ArrayList<Method>();
		Method afterMethod = null;
		Method beforeMethod = null;
		for (Method method : methods) {
			if (method.isAnnotationPresent(Test.class)) {
				testList.add(method); 
			} 
			if (method.isAnnotationPresent(Before.class)) {
				beforeMethod = method;
			}
			if (method.isAnnotationPresent(After.class)) {
				afterMethod = method;
			} 
		} 
		Object obj = c.newInstance();
		//反射激活方法
		for (Method m : testList) { 
			if (beforeMethod != null) {
				beforeMethod.invoke(obj, null);
			} 
			m.invoke(obj, null); 
			if (afterMethod != null) {
					afterMethod.invoke(obj, null); 
			} 
		} 
	}
}
