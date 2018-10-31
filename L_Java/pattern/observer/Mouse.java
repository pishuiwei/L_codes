package observer;

/**
 * 具体观察者
 * @author PW 2018/04/07
 *
 */
public class Mouse implements MyObserver{

	@Override
	public void response() {
		System.out.println("老鼠努力的逃跑!");
	}

}
