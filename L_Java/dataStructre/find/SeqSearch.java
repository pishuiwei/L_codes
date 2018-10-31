package find;

/**
 * *线性表的查找：线性表示最简单的一个查找表的组织方式，一个线性表含有若干个结点，每个结点存放
 * 		一条查找记录，若在线性表中找到了关键值与给定值相同的记录，则查找成功，返回该记录的信息
 * 		或该记录在表中的位置；否则查找失败，返回特定的值。线性表查找可分为顺序查找、二分法查找
 * 		以及索引查找<br>
 * 
 * @author PW 2018/03/17
 *
 */
public class SeqSearch {
	
	/**
	 * *顺序查找：是一种最简单的查找方法。它的基本思想是：从表的一端开始，顺序扫描线性表，
	 * 		一次将扫描到的关键字和给定值k比较，若当前扫描到的关键字与k相等，则差找成功；
	 * 		若扫描结束后，任未找到关键字等于k的记录，则查找失败<br> 
	 * 
	 * *算法分析：顺序查找实际上是将关键字与序列中每个元素进行一次比较从而确定结果的查找方法，
	 * 		其算法复杂度与序列表的长度有直接关系，若查找成功，则比较次数小于或者等于n；若
	 * 		查找不成功，则查找次数为n。所以，顺序查找的时间复杂度为O(n)<br>
	 * 
	 * @param a 目标数组
	 * @param x 要查找的数据 
	 */
	public void search(int[] a, int x) {
		int i = 0;
		while(i < a.length) {
			if (a[i] == x) {
				System.out.println("查找成功，查找的元素在序列中的位置为：" + (i + 1));
				return;
			}
		}
	}
	/**
	 * *二分查找：又称为折半查找。要求线性表示有序表，即表中记录按关键字有序。二分查找的基本思想是:
	 * 		设R[low...high]是当前查找区间，首先确定该区间的中点位置mid=（low+high）/2；
	 * 		然后将待查的k值与R[mid].key进行比较，若相等则查找成功并返回该位置，否则须返回确定
	 * 		新的查找区间；若R[mid].key > k 则由表的有序性可知R[mid].key < k,则由表的
	 * 		有序性可知R[mid...n-1].key均大于k，因此若表中存在关键字等于k的记录，则该记录必
	 * 		定是在位置mid左边的子表R[0...mid-1]中，故新的查找区间是左子表R[0..mid-1]；
	 * 		类似的，若R[mid.key] < k,则要查找的k必在mid的右子表中R[mid+1...n-1]中，
	 * 		即新的查找区间是右子表R[mid+1...n-1]。下一次查找是针对新的查找区间进行的。因此，
	 * 		可以从初始的查找区间R[0..n-1]开始，每经过一次与当前查找区间的中点位置上的关键字的
	 * 		比较，就可以确定查找是否成功，不成功则当前的查找区间缩小一半。这个过程重复直至找到关键字
	 * 		为k的记录，或者直至当前区间为空为止。<br>
	 * 
	 * 算法分析: 二分查找过程可用二叉树来描述，把当前查找区间的中间位置上的记录作为根，左子表和右子表
	 * 		中的记录分别作为根的左子树和右子树，由此得到的二叉树，称为描述二分查找的判定树或比较树。
	 * 		二分查找的平均查找长度为log2(n+1)-1,所以时间复杂度为O(log2n)<br>
	 * 
	 * @param a 目标数组
	 * @param k 要查找的数据 
	 */
	public void binSearch(int[] a, int k) {
		int find =  -1,
			low = 0, //开始点
			high = a.length - 1, // 结束点
			mid; // 中点
		while(low <= high) {
			mid =(low + high)/2;
			// 如果相等
			if (a[mid] == k) {
				find = mid;
				break;
			}
			// 不相等
			if (a[mid] > k) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		// 判断是否查找成功
		if (find > 0) {
			System.out.println("查找成功，该元素在表中位置为: " + find);
		} else {
			System.out.println("查找失败！");
		}
	}
	
	/**
	 * *分块查找：分块查找又称为索引查找，他是一种性能介于顺序查找和二分查找之间的查找方法。
	 * 		它要求按如下的索引方式来存储线性表：将R[0...n-1]均分为b块，前b-1块中的
	 * 		记录个数为s=n/b，最后一块即第b块的记录小于等于s；每块中的关键字不一定有序，
	 * 		但前一块中的最大关键字必须小于后一块的最小关键字，即要求表示“分块有序”的；抽
	 * 		取各块中的最大关键字及其起始位置构成一个索引表IDX[0..b-1]，即IDX[i]（
	 * 		0<=i<=b）中存放着第i块的最大关键字及该块在表R中的起始位置。由于表R是分块
	 * 		有序的，所以索引表示一个递增有序表。
	 * 分块查找的基本思想是：首先查找索引表，因为索引表是有序表，故可以采用二分查找或顺序查找，
	 * 		以确定待查记录在那一块；然后在已确定的块中进行顺序查找（因为内无序，只能用顺序
	 * 		查找）。如果在块中找到该记录则查询成功，否则查找失败。 
	 * 	
	 */
	public void searchIndex() {
		
	}
	
	public static void main(String[] args) {
		SeqSearch search = new SeqSearch();
		int[] i = {1,2,3,4,5,6,7,8,9};
		search.binSearch(i, 6);
		
	}

}