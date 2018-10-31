package string;

/**
 * 
 * String 是不可变得,每次改变都是创建新的String对象,
 * String对象具有只读行,所以指向它的任何引用都不可能改变它的值<br>
 * 
 * leangth() String中字符的个数
 * charAt() 取对应索引的char,索引从0开始
 * getBytes() getChars() 
 * toCharArray() 返回一个char[]
 * concat() 连接一个String,返回一个新的String
 * trim() 去掉两端的字符串
 * 
 * toUpperCase() 转换为大写
 * 
 * 
 * @author PP
 * 2017-08-26 00:04
 */
public class StringDemo {
	
	public  void d() {
		System.out.println(super.toString());
	}
	
	public static void main(String[] args) {
		String string = new String("ABCDEFG");
		string.replace("oldChar", "newChar");
		System.out.println(string.length());
		System.out.println(string.charAt(2));
		System.out.println(",");
		
	}
}





