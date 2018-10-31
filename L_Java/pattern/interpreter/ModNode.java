package interpreter;

/**
 * 求模结点类
 * @author PW 2018/04/07
 *
 */
public class ModNode extends SymbolNode{

	public ModNode(Node left, Node right) {
		super(left, right);
	}

	@Override
	public int interpret() {
		return left.interpret() % right.interpret();
	}

}
