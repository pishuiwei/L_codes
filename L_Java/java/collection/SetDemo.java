package collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Set 不包含重复元素,并且最大包含一个null元素<br>
 *
 * HashSet 由HashMap实现,元素唯一,无序(存储顺序和取出顺序不一致)<br><br>
 * 
 * LinkedHashSet 由哈希表和链表组成,哈希表保证元素唯一性,链表保证元素有序,(存储和取出一致)<br><br>
 * 
 * TreeSet 元素唯一,有序<br>
 * 
 * @author Administrator
 *
 */
public class SetDemo {

	public static void getAllSetElment() {
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		
		for(Integer integer : set){
			System.out.println(integer);
		}
	}
	
	
}
