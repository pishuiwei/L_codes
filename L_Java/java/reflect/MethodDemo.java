package reflect;

import java.lang.reflect.Method;

import base.P;

/**
 * 方法类
 * invoke() 调用方法
 * getAnnotation(Annotation.class) 获取注解类
 * @author PW 2018/01/01
 *
 */
public class MethodDemo {
	
	public static void main(String[] args) {
		printClassInfo(new String());
	}

	
	/**输出类的方法信息
	 * Class<br>
	 * getMethods 获取所有public方法,包括父类继承的方法<br>
	 * getDeclaredMethod 获取该类的所有方法,包括private,不包括父类的方法<br><br>
	 * 
	 * Method<br>
	 * getReturnType 获取返回类型<br>
	 * getName 获取方法名<br>
	 * parameterTypes 获取参数<br><br>
	 * 
	 */
	public static void printClassInfo(Object object){
		Class<?> c = object.getClass();
		System.out.println(">>>>类的名称:"+c);

		Method[] methods = c.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			Class<?> returnType = methods[i].getReturnType();
			P.print("返回类型>>>"+returnType+", ");
			
			P.print("方法明>>>"+methods[i].getName()+"(");
			
			Class<?>[] parameterTypes = methods[i].getParameterTypes();
			for (Class<?> class1 : parameterTypes) {
				P.print(class1.getName()+",");
			}
			P.println(object+")");
		}
	}
}
