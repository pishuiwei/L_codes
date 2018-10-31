package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 注解处理器
 * @author PW 2018/01/01
 *
 */
public class Demo {
	
	public static void check(Object o) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<Object> class1 = (Class<Object>) o.getClass();
		Method[] m = class1.getMethods();
		for(Method method : m) {
			if(method.isAnnotationPresent(Test.class)) {
				Test test = method.getAnnotation(Test.class);
				if(null != test) {
					method.invoke(o);
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Demo.check(new Demo());
	}
	
	@Test
	public void testA() {
		System.out.println("测试注解");
	}
	

}
