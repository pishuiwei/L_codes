package lineTable;

/**
 * *线性表（线性结构）-- 单链表
 * 链表概念：是指按链式存储结构存储的线性表。链表是指线性表中的结点在内存中随机存放，即存储单元即可以是连续
 *		    也可以不连续。因此为了保持链表各结点逻辑相邻的关系，就需要各节点在存放值得同时还要存放下一个结点
 *		    的地址。
 * 
 * 概念：单链表中结点要用两个区域，一个表示结点数据信息，称为数据域，一个表示当前结点的后续结点的引用，称为地址域
 * 头结点：若第一个结点仅表示链表的起始位置，而无任何值和意义，则称为头结点
 * 
 * 优点：插入、删除时，只要找到对应前驱结点，修改指针即可，无需移动元素；
 * 	        采用动态存储分配，不会造成内存浪费和溢出。
 * 缺点：在有些高级语言中， 不支持指针，不容易实现；
 * 	         需要用额外空间存储线性表的关系，存储密度小；
 *     不能随机访问，查找时要从头指针开始遍历，查找元素的时间复杂度较大。	
 * 
 * @author PW 2018/01/13
 *
 */
public class LinkList1<E> {
	// 头结点
	Node head = new Node();
	// 实际表长
	int curlen;
	
	// 结点内部类
	private class Node {
		public E e;
		public Node next;
		
		public Node() {
			e = null;
			next = null;
		}
	}
	
	/**
	 * 查询
	 * 1、在链表中查找某位置结点，则从链表头结点位置开始不断向下遍历链表，直到查找到对应位置的结点结束
	 * 2、返回查找结点，否则结点不存在。
	 * 
	 * @param i
	 * @return
	 */
	public Node query(int i) {
		Node p = head;
		if (i < 0 || i > curlen) {
			return p;
		}
		for (int j = 0; j <= i; j++) {
			p = p.next;
		}
		return p;
	}
	
	/**
	 * 插入
	 * 1、找到插入前位置，如存在则继续，否则结束；
	 * 2、申请、填装新结点；
	 * 3、插入新结点，结束。
	 * 
	 */
	public void insert(E e, int i) {
		Node data = new Node();
		data.e = e;
		if(i < 0 || i > curlen) {
			System.out.println("i值无效");
			return;
		}
		if (curlen == 0) {
			head.next = data;
		} else {
			// 查询插入元素的前一个元素
			Node p = query(i - 1);
			// 修改前一个元素的指针
			data.next = p.next;
			p.next = data;
		}
		curlen++;
	}
	
	/**
	 * 删除结点
	 * 
	 * 1、找到删除结点直接前驱对应的位置，若存在则继续，否则结束；
	 * 2、若要删除的结点存在则继续，否则继续；
	 * 3、删除对应位置结点，结束。
	 * 
	 * @param i
	 */
	public Node delete(int i) {
		Node node; // 保存删除的第i个结点
		// 判断删除位置是否正确
		if (i < 0 || i > curlen) {
			System.out.println("删除位置i无效");
			return null;
		}
		// 查找要删除结点的前一个元素
		Node p = query(i - 1);
		node = p.next;
		p.next = node.next;
		curlen--;
		return node;
	}
	
	public static void main(String[] args) {
		LinkList1<Integer> linkList1 = new LinkList1<>();
		linkList1.insert(1, 0);
		linkList1.insert(2, 0);
		linkList1.insert(3, 0);
		linkList1.insert(4 , 0);
		linkList1.delete(0);
		System.out.println(linkList1.query(0).e);
		System.out.println(linkList1.query(1).e);
		System.out.println(linkList1.query(2).e);
//		System.out.println(linkList1.query(3).e);
	}

}
