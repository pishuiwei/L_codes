package nestedClasses;

/**
 * 内部类调用外部内可以使用  外部类.this
 * 好处是在编译期间就知道了，因此没有任何的运行时开销
 * 
 * 2017-08-24
 * @author pp
 *
 */
public class DotThis {

	void f(){System.out.println("DotThis.f()");}
	
	public class Inner {
		public DotThis outer() {
			return DotThis.this;
		}
	}
	public Inner inner() { return new Inner(); }
	
	public static void main(String[] args) {
		DotThis dt = new DotThis();
		DotThis.Inner dti = dt.inner();
		dti.outer().f();
	}
	
}
