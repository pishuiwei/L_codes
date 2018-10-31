package find;

/**
 * *树表的查找：树表查找的对象是一二叉树或树作为表的组织形式。树表在进行插入和删除操作时，可以
 * 		方便地维护表的有序性，不需要移动表中的记录，从而减少因移动记录引起的额外时间开销。常
 * 		见的树表有二叉树、平衡二叉树、B-树和B+s树等<br>
 * 		<br>
 * 		二叉排序树实际上是增加了限制条件的特殊二叉树，限制条件的实质就是二叉排序树中任意一个
 * 		结点的关键字大于其左子树上所有结点的关键字，且小于其右子树上所有结点的关键字。这样的
 * 		限制给查找操作的实现提供了清晰的思路：一颗以二叉链表为存储结构的二叉排序树上，要找到
 * 		必某结点x小的结点，就只需要通过x结点的左指针到它的左子树上去查找，若要找到比某结点x
 * 		大的结点，只需要通过x结点的右指针到它的右子树上去找。可以证明，二叉排序树的中序遍历的
 * 		序列是按结点关键字递增排序的有序序列。所以构造一颗二叉排序树就是对树结点关键字进行排序，
 * 		“排序树”也因此而得名。<br>
 * *二叉排序树的定义：二叉排序树或者是空树，或者满足如下性质的二叉树：
 * 		（1）若它的左子树非空，则左子树上所有记录的值均小于根记录的值；
 * 		（3）若它的右子树非空，则右子树上所有记录的值均大于根记录的值；		
 * 		（3）它的左、右子树分别也是二叉排序树；
 * *创建二叉排序树：从空二叉树开始，首先读入第一个结点作为二叉排序树的根结点；其次从读入第二个结点
 * 		起，将读入结点的关键字和根结点的关键字比较：
 * 		（1）读入的结点关键字等于根结点关键字，则说明树中有此结点，不做处理；
 * 		（2）读入的结点关键字大于根结点关键字，则将此结点插入根结点的右子树；
 * 		（3）读入的结点关键字小于根结点关键字，则将此结点插入根结点的左子树；
 * 		（4）在子树中的插入过程和前面的步骤（1）、（2）、（3）相同
 * 
 * 
 * @author PW 2018/03/18
 *
 */
public class TreeSearch {
	
}



class BST { //构建二叉排序树
	public BSTNode root;
	public BST() {
		this.root = null;
	}
	
	public void insert(int data) {
		if (this.root == null) {
			root = new BSTNode();
			root.key = data;
		} else {
			bSTInsert(this.root, data);
		}
	}
	
	public void bSTInsert(BSTNode node, int key) {
		if (node==null || node.key==key) {
			return;
		} else if (node.key > key) {
			if (node.lchild == null) {
				BSTNode temp = new BSTNode();
				temp.key = key;
				node.lchild = temp;
			} else {
				bSTInsert(node.lchild, key);
			}
		} else {
			if (node.rchild==null) {
				BSTNode temp = new BSTNode();
				temp.key = key;
				node.rchild = temp;
			} else {
				bSTInsert(node.rchild, key);
			}
		}
	}
	
	public void createBFS(int[] a) { // 创建二叉排序树
		int i = 0;
		while (i<a.length) {
			this.insert(a[i]);
			i++;
		}
	}
	
	public void print() { //打印二叉排序树
		if (this.root == null) {
			System.out.println("树为空");
		} else {
			print(root);
		}
	}
	
	public void print(BSTNode node) { //中序遍历二叉树
		if (node == null) {
			return;
		} else {
			print(node.lchild);
			System.out.print(node.key + " ");
			print(node.rchild);
		}
	}
	
	/** 查找二叉排序树  */
	public BSTNode BSTSearch(int key) {
		if (this.root == null) {
			return null;
		} else {
			if (this.root.key == key) {
				return root;
			} else {
				return this.bSTSearch(root, key);
			}
		}
	}
	
	public BSTNode bSTSearch(BSTNode node, int key) {
		if (node.key == key) {
			return node;
		} else if (node.key > key) {
			if (node.lchild != null) {
				return bSTSearch(node.lchild, key);
			} else {
				return null;
			}
		} else {
			if (node.rchild!=null) {
				return bSTSearch(node.rchild,key);
			} else {
				return null;
			}
		}
	}

}

class BSTNode { // 二叉排序树节点类
	public int key;
	public BSTNode lchild;
	public BSTNode rchild;
	
	public BSTNode() {
		this.lchild = null;
		this.rchild = null;
	}
	
}
