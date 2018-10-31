package base;

/**
 * <p>方法中,'别名'显现
 * @author PP
 *
 */
public class PassObject {
	private static void f(Letter y) {
		y.c = 'z';
	}
	
	public static void main(String[] args) {
		Letter x = new Letter();
		x.c = 'a';
		System.out.println("1: x.c==" + x.c);
		
		f(x);
		System.out.println("2: x.c==" + x.c);
	}
}

class Letter {
	char c;
}