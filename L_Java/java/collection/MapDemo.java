package collection;

import java.util.Map;
import java.util.TreeMap;

/**
 * Map 允许对象null,而且没有限制个数,key唯一,无序<br>
 *	<p>put(K key,V value)  向集合中添加指定的key与value映射<br>
 *	containsKey(Object key) 如果此映射包含指定key的映射关系，则返回true<br>
 *	containsValue(Onject value) 如果此映射将一个或多个key映射到指定值，则返回true<br>
 *	get(Object key) 如果存在该key则返回对应的值，否则返回null<br>
 *	keySet() 返回该集合中的所有key独立形成的Set集合<br>
 *	valuse() 返回该集合中所有值对象的Collection集合<br><br>
 *
 *	HashMap类  允许使用nul键和null值.无序<br><br>
 *
 *	TreeMap类  具有一定的顺序，添加、删除和定位比HashMap类性能稍差.
 * @author Administrator
 *
 */
public class MapDemo {
	public static void  getAllMapElment() {
		Map<String, String> map = new TreeMap<String, String>();
		map.put("1","一");
		map.put("2","二");
		map.put("3","三");
		map.put("4","四");
		
		for(String key:map.keySet()){
			System.out.println("键:"+key+" " +"值:"+map.get(key));
		}
	}
}
