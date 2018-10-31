package observer;

/**
 * 具体目标
 * @author PW 201/04/07
 *
 */
public class Cat extends MySubject{

	@Override
	public void cry() {
		System.out.println("猫叫!");
		System.out.println("--------------------");
		
		for(MyObserver observer : observers) {
			observer.response();
		}
		
	}

	
}
