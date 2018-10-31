package base;

/**
 * <p>'短路'现象
 * <p>当表达式的值已近确定了,但是有部分逻辑代码没计算完,剩余的代码将不必计算,
 * 即:'短路'
 * @author PP
 *
 */
public class ShortCircuit {

	public static void main(String[] args) {
		boolean b = test1(0) && test2(2) && test3(2);
		System.out.println(b);
	}
	
	static boolean test1(int val){
		System.out.println("test1(" + val +")");
		System.out.println("result: " + (val<1));
		return val<1;
	}
	static boolean test2(int val){
		System.out.println("test2(" + val +")");
		System.out.println("result: " + (val<2));
		return val<2;
	}
	static boolean test3(int val){
		System.out.println("test3s(" + val +")");
		System.out.println("result: " + (val<3));
		return val<3;
	}	
}
