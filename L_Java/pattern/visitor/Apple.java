package visitor;

/**
 * 具体元素类，苹果
 * @author PW 2018/04/08
 *
 */
public class Apple implements Product{

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
