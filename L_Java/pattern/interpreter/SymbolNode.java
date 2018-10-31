package interpreter;

/**
 * 抽象非总结符表达式类
 * @author PW 2018/04/07
 *
 */
public abstract class SymbolNode implements Node{

	protected Node left;
	
	protected Node right;

	public SymbolNode(Node left, Node right) {
		this.left = left;
		this.right = right;
	}
	
}
