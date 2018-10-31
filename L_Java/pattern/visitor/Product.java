package visitor;

/**
 * 抽象元素类，商品类
 * @author PW 2018/04/08
 *
 */
public interface Product {
	
	public void accept(Visitor visitor);
	
}
