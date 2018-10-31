package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * List 有序,可重复<br>
 * 	get(int index); 获取指定索引位置的元素<br>
 *	set(int index，Object obj) 将集合中指定索引位置的对象修改为指定的对象<br>
 * ArrayList 线程不安全,底层使用数组实现,查询快,增删慢,效率高。每次容量不足时,自增长度的一半.<br>
 * LinkedList 线程不安全,底层使用链表实现,查询慢,增删快,效率高<br>
 * 	getFirst()和element 返回列表的头,为空时抛出NpSuchElementException
 *  peek() 返回列表的头，为空时返回null
 *  
 *  removeFirst()和remove() 移除并返回列表的头,列表为空时抛出NpSuchElementException
 *  poll() 移除并返回列表的头,列表为空时返回null
 *  
 *  addFirst()与add()和addLast()相同,将某个元素插入到列表的尾部
 *  
 *  removeLast() 移除并返回列表的最后一个元素
 * 
 * Vector 线程安全,底层使用数组实现,查询快,增删慢,效率低.每次容量不足时,默认自增长度的一倍.<br>
 * 
 * @author PP
 *
 */
public class ListDemo {
	
	public static void main(String[] args) {
		System.out.println(fill(new ArrayList<String>()));
	}
	
	public static Collection<String> fill(Collection<String> collection){
		collection.add("1");
		collection.add("2");
		collection.add("3");
		collection.add("4");
		return collection;
	}
	
	public void byForGet(){
		for(Integer i : getList()){
			System.out.println(i);
		}
	}
	
	public void byIteratorGet(){
		Iterator<Integer> iterator = getList().iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	public List<Integer> getList(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(0, 4);
		list.remove(0);
		return list;
	}
}
