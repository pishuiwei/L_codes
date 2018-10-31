package base;

import java.util.ArrayList;
import java.util.List;

public class P {
	
	public static void main(String[] args) {
//		test("1","2","3","4","5",1,"匹配");
		
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		for(String string : list){
			System.out.println(string);
		}
	}
	
	/**
	 * <p>e表示指数,而非常量e=2.718...
	 * <p>即:10e3 = 10*10*10
	 */
	public static void getE(){
		System.out.println(10e3);
	}
	
	/**
	 * <p>可变参数
	 * <p>适用于参数个数不确定，类型确定的情况，java把可变参数当做数组处理
	 * <p>注意：可变参数必须位于最后一项,且只有一个
	 * @param parmas
	 */
	public static void test(Object... object) {
		for(Object s:object){
			println(s);
		}
		
	}
	
	/**
	 * 换行打印一条数据
	 * @param object
	 */
	public static void println(Object object) {
		System.out.println(object);
	}
	
	/**
	 * 不换行打印一条数据
	 * @param object
	 */
	public static void print(Object object) {
		System.out.print(object);
	}
}
