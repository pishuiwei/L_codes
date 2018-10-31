package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationClassTest {
	
	public static void main(String[] args) {
		Class<Test3> testClass = Test3.class;
		//因为注解是作用于类上面的，所以可以通过isAnnotationPresent来判断是否是一个  
		//判断是否有UserNameAnnotations注解的类  
		if (testClass.isAnnotationPresent(UserNameAnnotations.class)) {
			System.out.println("this is a Annotations class"); 
			//通过getAnnotation可以获取注解对象  
			UserNameAnnotations userNameAnnotations = (UserNameAnnotations) testClass.  
					 getAnnotation(UserNameAnnotations.class);
			if (userNameAnnotations != null) {  
				 System.out.println("value:" + userNameAnnotations.value());  
			} else {  
                System.out.println("null");  
            }  
		} else {  
            System.out.println("this is not Annotations class");  
        }  
	}
}


@Documented //文档  
@Retention(RetentionPolicy.RUNTIME) //在运行时可以获取  
@Target({ ElementType.TYPE, ElementType.METHOD}) //作用到类，方法，接口上等  
@Inherited //子类会继承  
@interface UserNameAnnotations {
	public String value() default "pp";
}


//第一个注解的测试类
@UserNameAnnotations( value = "initphp")
class Test1 {
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}













