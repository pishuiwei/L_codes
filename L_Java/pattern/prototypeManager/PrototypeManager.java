package prototypeManager;

import java.util.Hashtable;

/**
 * 原型管理器
 * @author PW 2018/04/01
 *
 */
public class PrototypeManager {
	
	private Hashtable<String, MyColor>  ht = new Hashtable<>();
	
	
	public PrototypeManager() {
		ht.put("red", new Red());
		ht.put("blue", new Blue());
	}
	
	public void addColor(String key, MyColor obj) {
		ht.put(key, obj);
	}
	
	public MyColor getColor(String key) {
		return (MyColor)((MyColor) ht.get(key).clone());
	}
}
