package strategy;

import java.util.Arrays;

public class Demo {
	
	public static void main(String[] args) {
		int[] arr = {9,8,7,6,5,4,3,2,1,11};
		ArrayHandler arrayHandler = new ArrayHandler();
		arrayHandler.setSortObj(new InsertionSort());
		
		System.out.println(Arrays.toString(arrayHandler.sort(arr)));
	}
	
}
