package exception;

/**
 * try{}catch(Exception e){} 只是捕获了异常,不会提示异常在哪里
 * throws 用在方法上,可以抛出多个异常
 * throw 声明一个异常 
 * finally作用域不受return的影响，任何时候都会执行
 * 
 * @author PP
 * 2017-08-26
 */
public class MyException extends Exception{
	private static final long serialVersionUID = -5574608697149386242L;
	
	public MyException() {}
	
	public MyException(String arg0) {
		super(arg0);
	}
}




