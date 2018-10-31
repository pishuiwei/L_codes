package interpreter;

/**
 * 乘法结点类
 * @author PW 2018/04/07
 *
 */
public class MulNode extends SymbolNode{

	public MulNode(Node left, Node right) {
		super(left, right);
	}

	@Override
	public int interpret() {
		return super.left.interpret() * super.right.interpret();
	}

}
