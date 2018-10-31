package singleton;

/**
 * 单列模式：对象创建型模式
 * 
 * @author PW 2018/03/28
 *
 */
public class Singleton {

	private final static Singleton SINGLETON = new Singleton();
	
	private Singleton() {};
	
	public static Singleton getInstance() {
		return SINGLETON;
	}
	
}
