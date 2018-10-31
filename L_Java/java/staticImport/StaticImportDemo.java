package staticImport;

import java.util.Date;

import static java.lang.System.out;
import static staticImport.StaticMethods.tetsStatic;
/**
 * <p>演示静态导入
 * <p>import xxxx 和 import static xxxx的区别
 * 是前者一般导入的是类文件如import java.util.Scanner;
 * 后者一般是导入静态的方法
 * @author pp
 *
 */
public class StaticImportDemo {
	
	public static void main(String[] args) {
		/*自己的静态方法*/
		tetsStatic();
		/*系统的*/
		out.print("Hello,it's:");
		out.print(new Date());
	}

}
