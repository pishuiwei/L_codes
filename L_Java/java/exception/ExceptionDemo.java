package exception;

public class ExceptionDemo {
	
	public static void f() throws MyException{
		throw new MyException("sss");
	}
	
	public static void main(String[] args) {
		try {
			f();
		} catch (MyException e) {
			System.out.println(e.getMessage());
			return;
		}finally {
			System.out.println("finally 作用域");
		}
	}

}
