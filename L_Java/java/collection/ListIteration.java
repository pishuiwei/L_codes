package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * ListIteration 只适用于List
 * 可以双向移动
 * set() 替换最后一个访问的元素
 * listIterator(n) 创建一个一开始就指向索引n的ListInterator
 * 
 * hasPrevious() 是否有上一个
 * previous() 上一个元素
 * 
 * @author pp
 * 2017-08-26
 *
 */
public class ListIteration {
	
	private static final Character[] CHARS = {'a','b','c','d','e','f','g'};  

	public static void main(String[] args) {
		List<Character> characters = new ArrayList<Character>(Arrays.asList(CHARS));
		ListIterator<Character> it = characters.listIterator();
		while(it.hasNext()) {
			System.out.println(it.next() + "," + it.nextIndex() + "," + it.previousIndex());
		}
		System.out.println("--------------------");
		
		//----------//
		while(it.hasPrevious()) {
			System.out.print(it.previous() + " ");
		}
		System.out.println("****************");
		
		//---------//
		System.out.println();
		System.out.println(characters);
		System.out.println();
		it = characters.listIterator(3);
		while(it.hasNext()) {
			it.next();
			System.out.println(characters);
			it.set(characters.get(0));  
		}
		
	}

}
