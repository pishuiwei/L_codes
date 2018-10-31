package collection;

import java.util.LinkedList;

/**
 * 使用LinkedList实现Stack(栈，后进先出)
 * 
 * @author PP
 * 2017-08-26
 *
 * @param <T>
 */
public class Stack<T> {

	private LinkedList<T> storage = new LinkedList<T>(); 
	
	public void push(T v) { storage.addFirst(v); }

	public T peek() { return storage.getFirst(); }
	
	public T pop() { return storage.removeFirst(); }
	
	public boolean empty() { return storage.isEmpty(); }
	
	public String toString() { return storage.toString(); }
	
}
