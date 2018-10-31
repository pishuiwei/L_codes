package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 查看某个随机数出现了几次
 * containsKey() 判断指定键是否在Map中
 * containsValue() 判断指定值是否走Map中
 * 
 * @author pp
 * 2017-08-26
 */
public class Statistics {
	public static void main(String[] args) {
		Random random = new Random(47);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < 1000; i++) {
			int r = random.nextInt(20);
			Integer freq = map.get(r);
			map.put(r, freq == null ? 1 : freq + 1);
			System.out.println(freq + ",");
		}
		System.out.println(map);
	}

}
