package lineTable;

/**
 * *线性表（线性结构）-- 循环列表
 * 对于单链表而言，最后一个结点的地址为空，如果表示最后一个结点的指针域指向头结点，整个链表形成一个环，就构成了单循环链表
 * 
 * 与单链表相比，只是将原来判断指针是否为空变为判断是否是头指针，没有其他的变化
 * 
 * 访问单循环链表某一结点，可以从任何一个结点开始，顺序向后遍历到达要访问的结点。
 * 
 * @author PW 2018/01/14
 *
 */
public class CirLinkedList<E> {
	Node front; // 循环链表表头指针
	Node rear; // 循环链表表尾指针
	int length; // 表长度 
	
	private class Node {
		public E e;
		public Node next;
		
		public Node() {
			e = null;
			next = null;
		}
	}
	
	public void add(int i, E e) {
		
		
	}
	
}
