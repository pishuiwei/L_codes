package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import annotation.MethodType.MethodTypeEnum;


public class AnnotationFieldTest {
    public static void main(String[] args) {  
        Test3 test = new Test3();  
        Class<Test3> testClass = Test3.class;  
        try {  
            //因为是注解到Field上的，所以首先要获取这个字段  
            Field field = testClass.getDeclaredField("userName");  
  
            //判断这个Field上是否有这个注解  
            if (field.isAnnotationPresent(FieldAnnotations.class)) {  
                System.out.println("this is a field Annotation");  
  
                //如果有这个注解，则获取注解类  
                FieldAnnotations fieldAnnotations = (FieldAnnotations) field.getAnnotation(FieldAnnotations.class);  
                if (fieldAnnotations != null) {  
                    //通过反射给私有变量赋值  
                    field.setAccessible(true);  
                    field.set(test, fieldAnnotations.value());  
                    System.out.println("value:" + test.getUserName());  
                }  
            } else {  
                System.out.println("this is not  a field Annotation");  
            }  
  
        } catch (Exception e) {  
        }  
  
    }  
}
/** 
 * 定义一个作用到域上的自定义注解 
 */  
@Documented//文档  
@Retention(RetentionPolicy.RUNTIME)//在运行时可以获取  
@Target({ ElementType.FIELD })//作用到类的域上面  
@interface FieldAnnotations {  
  
    public String value() default ""; //使用的时候 @FieldAnnotations(value="xxx")  
  
}  

/** 
 * 一个注解的测试类 
 * @author zhuli 
 * @date 2014-7-5 
 */  
//注入注解作用于类上面  
//可以通过反射 获取类的信息之后 获取得到这个注解的值  
@UserNameAnnotations(value = "initphp")   
class Test3 {  
  
    @FieldAnnotations(value="zhuli")  
    private String userName;  
  
    //注解到  
    @MethodType(methodType=MethodTypeEnum.TYPE2)  
    public String getUserName() {  
        return userName;  
    }  
  
    public void setUserName(String userName) {  
        this.userName = userName;  
    }  
  
}  