package nestedClasses;

/**
 * 局部内部类
 * 匿名内部类
 * 嵌套类(static类)
 * @author PP
 *
 */
public class Parcel15 {
	public Contents contents() {
		return new Contents() {
			public int value() { return 0; }
		};
	}
	
}
