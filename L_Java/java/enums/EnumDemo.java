package enums;

/**
 * ordinal,输出enum常量的申明顺序
 * @author PP
 *
 */
public class EnumDemo {
	public static void main(String[] args) {
		Color c = Color.GREEN;
		System.out.println("编号： " + c.getIndex() + "；名称：" + c.getName());
		System.out.println(c.name());
		System.out.println(Color.getOrdinal(c.getName()));
	}
}

