package reflect;

import base.P;
/**
 * 通过反射机制可以获取类的构造方法、成员变量、方法等<br>
 * 有三种方法获取Class对象<br>
 * instanceof  比较这个对象是这个类或者这个类的派生类吗
 * 
 * getName() 获取类的全限定名(包含包名)
 * getCanonicalName() 获取类的全限定名(包含包名)
 * getSimpleName 获取类名(不包含包名)
 * getInterfaces() 获取类实现的全部接口(返回Class<?>[]数组)
 * getSuperclass() 获取直接基类
 * newInstance() 创建此对象(必须有默认构造方法)
 * isInstance()
 * isAssignableFrom() 
 * 
 * getMethods() 获取Methods数组
 * getConstructors() 获取Constructors数组(构造器)
 * 
 * 
 * 
 * 
 * 2017-08-30 22:46
 * @author PP
 *
 */
public class ClassDemo{
	
	public void getClassDemo() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		User u = new User();
		//方法一
		Class<?> c1 = User.class;
		P.println("方法一:"+c1);
		//方法二
		Class<?> c2 = u.getClass();
		P.println("方法二:"+c2);
		//方法三
		Class<?> c3 = Class.forName("learnReflect.User");
		P.println("方法三:"+c3);
		
		//可以通过类的类型创建该类的实例对象
		User user = (User)c1.newInstance();
	}
	
	public void castDemo() {
		//cast 实现向下转型
		Edit edit = new User();
		Class<User> class1 = User.class;
		User user2 = class1.cast(edit);	
	}
	
	public static void main(String[] args) {
		System.out.println(args[0]);
		
	}	
}
class User implements Edit{
	 
}

interface Edit {

}



