package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;  

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)//注解信息保留到运行时 
public @interface Before { 
	
}