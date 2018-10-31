package sort;

import java.util.Arrays;

/**
 * *交换排序
 * 
 * *冒泡排序
 * 
 * *快速排序
 * 
 * @author pp
 *
 */
public class ChangeSort {
	
	public static void main(String[] args) {
		ChangeSort.bubbleSort(new int[]{9,8,7,6,5,4,3,2,1,0});
	}

	/** 冒泡排序 */
	public static void bubbleSort(int[] data) {
		int i, j, flag = 1;
		int temp;
		for (i = 0; i < data.length && flag == 1; i++) {
			for ( j = 0; j < data.length - i -1; j++) {
				if (data[j] > data[j+1]) {
					flag = 1;
					temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(data));
	}
	
	/** 快速排序 */
	public void quickSort(int[] data) {
		
	}
	
}
