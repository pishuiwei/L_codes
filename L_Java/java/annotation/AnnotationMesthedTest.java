package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import annotation.MethodType.MethodTypeEnum;

public class AnnotationMesthedTest {
	public static void main(String[] args) {
		Class<Test2> testClass = Test2.class;
		try {
			// 因为是注解到method上的，所以首先要获取这个方法
			Method method = testClass.getDeclaredMethod("getUserName");

			// 判断这个方法上是否有这个注解
			if (method.isAnnotationPresent(MethodType.class)) {
				System.out.println("this is a method Annotation");

				// 如果有这个注解，则获取注解类
				MethodType methodType = (MethodType) method.getAnnotation(MethodType.class);
				if (methodType != null) {
					if (MethodTypeEnum.TYPE1.equals(methodType.methodType())) {
						System.out.println("this is TYPE1");
					} else {
						System.out.println("this is TYPE2");
					}
				}
			} else {
				System.out.println("this is not  a method Annotation");
			}

		} catch (Exception e) {
		}

	}
}

/**
 * 定义一个作用到方法的注解
 */
@Documented // 文档
@Retention(RetentionPolicy.RUNTIME) // 在运行时可以获取
@Target({ ElementType.TYPE, ElementType.METHOD }) // 作用到类，方法，接口上等
@interface MethodType {
	// 枚举类型
	public enum MethodTypeEnum {
		TYPE1, TYPE2
	}

	// 实际的值
	public MethodTypeEnum methodType() default MethodTypeEnum.TYPE1;
}

/**
 * 一个注解的测试类
 * 
 * @author zhuli
 * @date 2014-7-5
 */
// 注入注解作用于类上面
// 可以通过反射 获取类的信息之后 获取得到这个注解的值
@UserNameAnnotations(value = "initphp")
class Test2 {

	private String userName;

	// 注解到
	@MethodType(methodType = MethodTypeEnum.TYPE2)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
