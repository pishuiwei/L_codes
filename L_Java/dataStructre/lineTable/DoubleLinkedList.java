package lineTable;

/**
 * *线性表（线性结构）-- 双链表(双向链表)
 * 双链表的每个结点中都有两个指针，分别指向直接后续和直接前驱
 * 
 * @author PW 2018/01/14
 *
 */
public class DoubleLinkedList<E> {
	Node head = new Node(); // 头结点
	int curlen; // 实际表长
	
	private class Node {
		public E e;
		public Node prev; // 前驱结点
		public Node next; // 后续结点
		
		public Node() {
			this.e = null;
			this.prev = null;
			this.next = null;
		}
	}
	
	/**
	 * 查询结点
	 * 
	 * @param i
	 * @return
	 */
	public Node query(int i) {
		Node p = head;
		for(int j = 1; j <= i; i++) {
			p = p.next;
		}
		return head;
	}

	/**
	 * 插入
	 * 
	 * 1、找到插入前位置，如存在则继续，否则结束
	 * 2、申请、填装新结点
	 * 3、插入新结点，结束
	 * 
	 */
	public void add(int i, E e) {
		Node data = new Node();
		data.e = e;
		// 判断i的有效性
		if (i < 0 || i > curlen) {
			System.out.println("插入位置无效");
			return;
		}
		// 找到在i前面的一个结点
		Node p = query(i - 1);
		p.next.prev = data;
		p.next = data;
		data.next = p.next;
		data.prev = p;
		curlen++;
	}
	
	/**
	 * 删除
	 * 
	 * 1、找到删除结点直接前驱对应的位置，如存在则继续，否则结束
	 * 2、若要删除的结点存在则继续，否则结束
	 * 3、删除对应位置的结点，结束
	 * 
	 */
	public void delete(int i) {
		if (i < 0 || i > curlen) {
			System.out.println("删除位置无效");
			return;
		}
		Node p = query(i - 1);
		p.next = p.next.next;
		p.next.next.prev = p;
		curlen--;
	}
}



