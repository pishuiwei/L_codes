package interpreter;

/**
 * 除法类
 * @author PW 2018/04/07
 *
 */
public class DivNode extends SymbolNode{

	public DivNode(Node left, Node right) {
		super(left, right);
	}

	@Override
	public int interpret() {
		return super.left.interpret() / super.right.interpret();
	}

}
