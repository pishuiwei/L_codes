package collection;

import java.util.ArrayList;
import java.util.List;

public class ApplesAndOranagesWithoutGenerics {

	public static void main(String[] args) {
		List<Apple> apples = new ArrayList<Apple>();
		for(int i = 0; i < 3; i++) {
			apples.add(new Apple());
		}
		for(Apple apple : apples) {
			System.out.println("------" + apple.id() );
		}
		System.out.println("苹果的个数: " + apples.size());
		System.out.println(apples.get(0).getClass() );
	}
}

class Apple{
	private static  long counter = 1;
	private final long id = counter++;
	public long id() {
		return id;
	}
}

class Orange{}
