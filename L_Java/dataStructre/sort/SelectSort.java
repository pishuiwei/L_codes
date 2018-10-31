package sort;

/**
 * *选择排序
 * 
 * *直接选择排序
 * 
 * *推排序
 * 
 * @author PW 2018/03/18
 *
 */
public class SelectSort {

	/** 直接选择排序 */
	public void selectSort(int[] data) {
		int i, j, small;
		int temp;
		for (i = 0; i < data.length - 1; i++) {
			small = i;
			for (j = i+1; j < data.length; j++) { //寻找最小的数据元素
				if (data[j] < data[small]) {
					small = j; // 记录最小的数据元素
				}
			}
			if (small != i) { // 交换数据元素
				temp = data[i];
				data[i] = data[small];
				data[small] = temp;
			}
		}
	}
	
	/** 推排序 */
	public void stackSort(int[] data) {
		
	}
	
}
