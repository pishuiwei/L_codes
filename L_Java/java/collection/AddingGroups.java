package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AddingGroups {

	public static void main(String[] args) {
		Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3));
		//Arrays.asList()
		Integer[] moreInts = {4, 5, 6};
		collection.addAll(Arrays.asList(moreInts));
		System.out.println(collection);
		
		//Collection.addAll()
		Collections.addAll(collection, 7,8,9);
		System.out.println(collection);
		
		Map<Integer, Integer> map =  new HashMap<Integer, Integer>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		System.out.println(map);
	}
}
