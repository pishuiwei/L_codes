package tree;

/**
 * *线索二叉树
 * 概念：在二叉树的链式存储结构中，增加指向前驱和后续结点的信息，称为线索。加上线索的二叉树为线
 * 索二叉树。对二叉树一某种次序进行遍历使其成为线索二叉树的过程称为线索化。
 * 
 * *线索化二叉树
 * 在由n个结点构成的二叉树链式存储结构中，存在着n+1个King链域。可利用这些空链域建立起相应结点
 * 的前驱结点信息和后续结点信息。在二叉树链中，如果某结点有左子树，则其lChild域指向其左孩子，否
 * 则其lChild域指向该结点在遍历序列中的前驱结点；如果某个结点有右子树，则其rChild域指向其右
 * 孩子，否则其rChild指向该结点在遍历序列中的后续结点。
 * 为了区分一个结点中lChild域和rChild域指向的是左、右孩子还是前驱、后续，需要在结点中再增设
 * 两个线索标志域lTag和rTag来区分这两种情况
 * [lChild lTag data rTag rChild]
 * 
 * 分为前序、中序、后续线索化二叉树，其中最实用的是中序线索化二叉树
 * 
 * @author PW 2018/03/15
 *
 */
public class BinThrTree {
	char data; 			  // 根结点数据
	boolean leftIsThread; // 左孩子是否为线索
	BinThrTree left;	  // 左子树
	boolean rigthIsThread;// 右孩子是否为线索
	BinThrTree right;	  // 右子树
	static BinThrTree pre = null;//线索化的时候保存前驱
	
	public BinThrTree(char data) {
		this.data = data;
		this.leftIsThread = false;
		this.left = null;
		this.rigthIsThread = false;
		this.right = null;
	}
	
	/** 中序线索化二叉树 */
	public static void inThread(BinThrTree root) {
		if (root != null) {
			inThread(root.left); // 线索化左孩子
			if (null == root.left) { // 左孩子为空
				root.leftIsThread = true; // 将左孩子设置为线索
				root.left = pre;
				System.out.println(((pre!=null)?pre.data:"null") + "<-" + root.data);
			}
			if (pre!=null && null==pre.right) { // 右孩子为空
				pre.rigthIsThread = true;
				pre.right = root;
				System.out.println(pre.data + "->" + root.data);
			}
			pre = root;
			inThread(root.right); // 线索化右孩子
		}
	}
	
	/**
	 * *中序遍历线索二叉树
	 * 从根结点开始，只要根结点非空，并且其左孩子不是线索，就循环递进用其左孩子迭代根结点，
	 * 直到其左孩子是线索为止；然后访问当前根结点；如果右孩子是线索，则迭代线索所指的后续为
	 * 根结点，访问之，否则存在右孩子，继续循环递进其左孩子迭代根结点，直到其左孩子是线索为
	 * 止。
	 */
	public static void inThreaOrder(BinThrTree root) {
		if (root != null) {
			while(root!=null && !root.leftIsThread) { //如果左孩子不是线索
				root = root.left; //
			}
			do {
				System.out.println(root.data + ",");
				if (root.rigthIsThread) { // 如果孩子是线索
					root = root.right;
 				} else { // 有右孩子
 					root = root.right;
 					while(root!=null && !root.leftIsThread) {
 						root = root.left;
 					}
 				}
			} while (root!=null);
		}
	}
}





