package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象目标类
 * @author PW 2018/04/07
 *
 */
public abstract class MySubject {
	
	protected List<MyObserver> observers = new ArrayList<>();
	
	// 注册方法
	public void attach(MyObserver observer) {
		observers.add(observer);
	}
	
	// 注销方法
	public void detach(MyObserver observer) {
		observers.remove(observer);
	}

	// 抽象通知类
	public abstract void cry();
}
