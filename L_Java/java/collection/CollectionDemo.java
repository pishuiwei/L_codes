package collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import base.P;

/** 
 *  层次结构中的根元素，Set、List、等继承于它<br>
 * 	add(E e)  将指定的对象添加到该集合中<br>
 *	remove(Object o) 将指定的元素从该集合中删除<br>
 *	isEmpty() 返回boolean，用与判断该集合是否为空<br>
 *	iteraor() 用于遍历集合中的对象<br>
 *	size() 返回int型值，获取该集合中元素个数<br>
 *	Iterator中next()方法返回的是Object 用于获取集合中的元素<br>
 *
 *  Arrays.asList() 接受一个数组或用逗号分隔开的元素列表,返回一个List对象<br>
 *  Collections.addAll(Collection c,Object... t),将元素添加到容器<br>
 *  collection.addAll(Collection c)
 *  
 *  @author PP
 *  2017-08-26
 *
 */
public class CollectionDemo {
	
	/**
	 * Collection基本操作
	 */
	public void collectionDemo(){ 
		Collection<Integer> collection = new HashSet<Integer>();	
		collection.add(1);
		collection.add(2);
		collection.add(3);
		
		Iterator<Integer> iterator = collection.iterator();
		for(int i = 0; i < 2; i++){
			iterator.next();
			iterator.remove();
		}
		
		while(iterator.hasNext()){
			P.println(iterator.next());
		}		
	}
	
	public void fillingLists() { 
		String string = "S";
		string.hashCode();
	}
	
	public static void main(String[] args) {

	}
	
}
