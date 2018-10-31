package tree;

/**
 * *二叉树
 * 是结点的有限集合，这个集合或者为空，或者是由一个根结点和两棵互不相交的分别称为左子树和右子
 * 树的二叉树组成。二叉树中每个结点至多有两棵子树，且子树有左右之分，次序不能颠倒。
 * 
 * 二叉树的5种形态：空二叉树、只有根结点的二叉树、根结点和左子树、根结点和右子树、根结点和左右子树
 * 
 * 树与二叉树的区别：1、二叉树的一个结点至多有两个子树，树则不然；2、二叉树一个结点的子树有左右之
 * 分，二树的子树没有次序
 * 
 * 二叉树的性质
 * 1、二叉树第i层上的结点数目最多为2^i-1
 * 2、深度为k的二叉树至多有2^k-1个结点
 * 3、任意二叉树中，若叶结点的个数为n0，度为2的结点树为n2,则n0=n2+1
 * 	    满二叉树：深度为k且有2^k-1个结点的二叉树称为满二叉树
 * 	    完全二叉树：若一棵二叉树至多只有最下面的两层上结点的度数可以小于2，并且最下一层上
 * 的结点都集中在该层最左边的若干位置上，则此二叉树称为完全二叉树
 * 	  （1）满二叉树是完全二叉树，反之不成立
 *   （2）对于完全二叉树。若某结点无左孩子，则必无右孩子，该结点为叶子结点
 * 4、具有n个结点的完全二叉树的深度为[log2n]+1 ([log2n]表示该值得最大整数)
 * 5、如果对一颗有n个结点的完全二叉树的结点按层次编号（即自上二下，自左至右），则对任意结点i(1<=i<=n),有
 *   （1）如果i=1,则结点i是二叉树的根，无双亲；如果i>1，则双亲的编号为[i/2]的结点
 *   （2）如果2*i>n,则结点i无左孩子；否则其左孩子是编号为2*i的结点
 *   （3）如果2*i+1>n,则结点i无右孩子；否则其右孩子是编号为2*i+1的结点
 *   （4）若i为奇数且不为1,则结点i的左兄弟的编号是i-1；否则，结点i无左兄弟
 *   （5）若i为偶数且小于n,则结点i的右兄弟的编号是i+1；否则，结点i无右兄弟
 *   
 * 二叉树存储结构
 * 1、二叉树的顺序存储结构
 * 2、二叉树的链式存储结构 [lChild data rChild]   
 * 
 * 二叉树的遍历
 * 二叉树遍历的概念：二叉树的遍历是指沿某条搜索路径访问二叉树，对二叉树中的每个结点访问一次且仅
 * 一次。这里的“访问”实际上是指对结点进行某种操作。
 *  ⑴访问结点本身（N），
 *	⑵遍历该结点的左子树（L），
 *	⑶遍历该结点的右子树（R）。
 * （1）前序遍历(NLR)：若二叉树非空，先访问根结点，再前序遍历左子树，最后前序遍历右子树
 * （2）中序遍历(LNR)：若二叉树非空，先中序遍历左子树，再访问根结点，最后中序遍历右子树
 * （3）后序遍历(LRN)：若二叉树非空，先后序遍历左子树，再后序遍历右子树，最后访问根结点
 * 
 * @author PW 2018/03/15
 *
 */
public class BinTree {
	char data;    // 根结点数据
	BinTree left; // 左子树
	BinTree right;// 右子树
	
	public BinTree(char data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public static void preOrder(BinTree root) { //前序遍历
		if(root != null) {
			System.out.print(root.data + "-");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public static void inOrder(BinTree root) { //中序遍历
		if(root != null) {
			inOrder(root.left);
			System.out.print(root.data + "-");
			inOrder(root.right);
		}
	}
	
	public static void postOrder(BinTree root) { //后序遍历
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.data + "-");
		}
	}
}
