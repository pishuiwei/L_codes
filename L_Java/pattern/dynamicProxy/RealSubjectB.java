package dynamicProxy;

/**
 * 真实主题B
 * @author PW 2018/04/01
 *
 */
public class RealSubjectB implements AbstractSubject{
	         
	@Override
	public void request() {
		System.out.println("真实主题B!");
	}
	
}
