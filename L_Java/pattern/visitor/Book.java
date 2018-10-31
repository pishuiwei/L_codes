package visitor;

/**
 * 具体元素类，书籍
 * @author PW 2018/04/08
 *
 */
public class Book implements Product{

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
