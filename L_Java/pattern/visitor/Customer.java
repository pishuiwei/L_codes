package visitor;

/**
 * 具体访问者
 * @author PW 2018/04/08
 *
 */
public class Customer extends Visitor{

	@Override
	public void visit(Apple apple) {
		System.out.println("顾客" + name + "选择苹果。");
	}

	@Override
	public void visit(Book book) {
		System.out.println("顾客" + name + "买书。");
	}

}
