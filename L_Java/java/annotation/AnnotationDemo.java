package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationDemo {
	
	@Constructor_Annotation(value = "1")
	public static void p(){
		System.out.println("注解执行了");
	}
	
	public static void main(String[] args) {

	}
}

@Target({ElementType.METHOD}) //适用于的范围,可多选
@Retention(RetentionPolicy.RUNTIME) //表示需要在什么级别保存注解信息
@Documented //将注解包含在Java doc中
@Inherited //允许自雷继承父类中的注解
@interface Constructor_Annotation{
	String value() default "Hello";
	String describe() default "<默认构造方法>";
}
