package interpreter;

/**
 * 终结符表达式
 * @author PW 2018/04/07
 *
 */
public class ValueNode implements Node{

	private int value;
	
	public ValueNode(int value) {
		this.value = value;
	}
	
	@Override
	public int interpret() {
		return value;
	}

}
