package sort;

import java.util.Arrays;

/**
 * *插入排序
 * 
 * *直接插入排序：假设待排序的记录存放在数组r[1..n]中，任何一个待排序的记录初始状态可以
 * 		看成是这种情况：初始时，r[1]自成1个有序区，无序区为r[2...n]；
 * 		直接插入排序时一种最简单的排序方法，它的基本思想是：仅有一个记录的表，总是有序的，
 * 		因此，对有n个记录的表，可以从第二个记录开始直到第n个记录，逐个向有序表中进行插入
 * 		操作，从而得到n个记录按关键字有序的表。
 * 
 * *折半插入排序：直接插入排序的算法间接，容易实现，当n较小时时一种好的排序方法。当是一般情况
 * 		下记录序列中的记录数量都很大，则此时直接插入排序方法就不适用了；
 * 		而二分插入排序是在直接插入排序基础上改进的一种排序算法。由于插入排序的操作是在一个有序
 * 		序列中进行比较和插入的，而比较操作实际上就是在有序序列中作查找操作，这个“查找”操作可以
 * 		用“二分查找”的方法来实现。按照这种思想，对直接插入排序改进后的排序方法称为二分插入排序，
 * 		又称折半操作排序。与直接插入排序相比，二分插入排序仅仅减少了记录关键字的比较次数，二记录
 * 		的移动次数没有改变；
 * 
 * *希尔排序：
 * 		（1）选择一个步长序列t1，t2,...,tk,其中ti > tj, tk = 1;
 * 		（2）按步长序列个数k，对序列进行k趟排序;
 * 		（3）每趟排序根据对应的步长ti，将待排序序列分隔成若干长度为m的子序列，分别对各子表进行直接
 * 			插入排序、仅步长因子为1时，整个序列作为一个表来处理，表长度即为整个序列的长度；
 * 		
 * 
 * @author PW 2019/03/18
 *
 */
public class InsertSort {

	/** 直接插入排序 */
	public void insertSort(int[] data) {
		int i, j, temp;
		for (i = 0; i < data.length - 1; i++) {
			temp = data[i + 1];
			j = i;
			while(j > -1 && temp <= data[j]) {
				data[j + 1] = data[j];
				j--;
			}
			data[j + 1] = temp;
		}
	}
	
	/** 折半插入排序 */
	public void binInsertSort(int[] data) {
		int key, left, rigth, middle;
		for(int i = 1; i < data.length; i++) {
			key = data[i];
			left = 0;
			rigth = 1;
			while(left <= rigth) {
				middle = (left + rigth)/2;
				if (data[middle] > key) {
					rigth = middle - 1;
				} else {
					left = middle + 1;
				}
			}
			for(int j = i-1; j >= left; j--) {
				data[j+1] = data[j];
			}
			data[left] = key;
		}
	}
	
	/** 希尔排序 */
	public void shellSort(int[] data) {
		int j = 0;
		int temp = 0;
		for (int increment = data.length/2; increment > 0; increment/=2) {
			for (int i = increment; i < data.length; i++) {
				temp = data[i];
				for (j = i; j > increment; j-=increment) {
					if (temp < data[j - increment]) {
						data[j] = data[j - increment];
					} else {
						break;
					}
				}
				data[j] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] data = {2,3,9,8,7,6,54,33};
		InsertSort sort = new InsertSort();
		sort.insertSort(data);
		System.out.println(Arrays.toString(data));
	}
	
}
