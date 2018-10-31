package composite;

import java.util.ArrayList;
import java.util.List;

/** 水果盘子  */
public class Plate extends MyElement{

	List<MyElement> list = new ArrayList<>();
	
	public void add(MyElement element) {
		list.add(element);
	}
	
	public void remove(MyElement element) {
		list.remove(element);
	}
	
	@Override
	public void eat() {
		for(MyElement element : list) {
			element.eat();
		}
	}
	
}
