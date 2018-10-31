package visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 对象结构，购物车
 * @author PW 2018/04/08
 *
 */
public class BuyBasket {
	
	private List<Product> list = new ArrayList<>();
	
	public void accept(Visitor visitor) {
		Iterator<Product> i = list.iterator();
		while(i.hasNext()) {
			i.next().accept(visitor);
		}
	}
	
	public void add(Product product) {
		list.add(product);
	}

	public void remove(Product product) {
		list.remove(product);
	}
	
}
