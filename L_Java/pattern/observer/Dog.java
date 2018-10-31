package observer;

/**
 * 具体观察者
 * @author PW 2018/04/07
 *
 */
public class Dog implements MyObserver{

	@Override
	public void response() {
		System.out.println("狗跟着叫!");
	}

}
