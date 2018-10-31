package dynamicProxy;

/**
 * 真实主题类A
 * @author PW 2018/04/01
 *
 */
public class RealSubjectA implements AbstractSubject{

	@Override
	public void request() {
		System.out.println("真实主题类A!");
	}

}
