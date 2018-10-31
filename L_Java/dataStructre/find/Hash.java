package find;

/**
 * *哈希表的查找：在记录的存储位置和它的关键字之间建立一个确定的对应关系f，使每个关键字和表中
 * 		一个唯一的存储位置相对应，称这个对应关系f为哈希（散列）函数，根据这个思想建立的表称
 * 		为哈希表；<br>
 * 		<br>
 *		在哈希表中，若出现key1 ≠ key2 ，而f(key1) = f(key2)，则这种现象称为地址
 *		冲突，key1和key2对哈希函数f来说是同义词。根据设定的哈希函数f=H(key)和处理冲突
 *		的方法，将一组关键字映射到一个有限的连续的地址集上，并以关键字在地址中的"象"作为纪录
 *		中的存储位置，这一映射过程为构造哈希表（散列表）<br>
 *		<br>
 *		好的哈希表应该使一组关键字的哈希地址均匀分布在整个哈希表中，从而减少冲突，常用的构造哈
 *		希函数的方法有：
 *		（1）直接地址法：去关键字或关键字的某个线性函数值为哈希地址，即H(key) = key或者
 *			H(key) = a*key+b,其中，a和b为常数；
 *		（2）数字分析法：假设关键字是r进制数（如十进制数），并且哈希表中有可能出现的关键字都是
 *			事先知道的，则可以选取关键字的若干数位组成哈希地址。选取的原则是使得到的哈希地址尽
 *			量避免冲突，即所选数位上的数字尽可能是随机的；
 *		（3）平法取中发：取关键字平方后的中间几位为哈希表地址。这是一种比较常用的方法。通常在选定
 *			哈希函数时不一定能知道关键字的全部情况，仅取其中的几位为地址不一定合适，而一个数平方
 *			后的中间几位数和数的每一位都相关，由此得到的哈希地址随机性更大。取得位数由表长决定。
 *		（4）保留余数法：取关键字被某个不大于哈希表长m的数p除后所得的余数为哈希地址，即：
 *			H(key) = key mod p(p<=n)。这是一种最简单、最常用的方法，它不仅可以对关键字
 *			直接去摸，也可以折叠、平方取中等运算上去摸；
 * 		<br>
 * 		采用均匀的哈希函数可以减少地址冲突，但是不能避免冲突，因此，必须有良好的方法来处理冲突，通常，
 * 		处理地址冲突的方法有一下两种：
 * 		（1）开放地址法：在开放地址法中，以发生冲突的哈希地址为自变量，通过某周哈希冲突函数得到一个新
 * 			的空闲的哈希地址。这种得到新地址的方法有很多，主要有线性探查法和平法探查法。线性探查法是
 * 			从发生冲突的地址开始，依次探查该地址的下一个地址，直到找到一个空闲单元为止。而平法探查法
 * 			则是在发生冲突的地址上加减某个因子的平方作为新的地址；
 * 		（2）拉链法：是把所有的同义词有单链表连接起来的方法。在这种方法中，哈希表中每个单元中存放的不再
 * 			是记录本身，而是相应同义词单链表的头指针；
 * 
 * 
 * 
 * @author PW 2018/03/18
 *
 */
public class Hash {
	public int[] key;
	public int nullkey = -1;
	public int count = 0;
	
	public Hash() {
		this.key = new int[50];
	}
	
	public void insertHt(Hash ha, int key, int p,int m) {
		int i,
			adr;
		adr = key%p;
		if (ha.key[adr] == nullkey) {
			ha.key[adr] = key;
			ha.count = 1;
		} else {
			i = 1;
			do {
				adr = (adr + 1) % m;
			} while (ha.key[adr] != nullkey);
			ha.key[adr] = key;
			ha.count = i;
		}
	}
	
	 public void createHt(Hash ha, int[] a, int n, int m, int p) {
		 int i;
		 for (i = 0; i < m ; i++) {
			ha.key[i] = nullkey;
			ha.count = 0;
		}
		 for (i = 0; i < n ; i++) {
			insertHt(ha, a[i], p, m);
		}
	 }
	
	 public void dispHT(Hash ha, int m) {
		 int i;
		 for (i = 0; i < m; i++) {
			System.out.println(i + " ");
		}
		 System.out.println();
		 for (i = 0; i < m; i++) {
			if (ha.key[i] != nullkey) {
				if (ha.key[i] < 10) {
					System.out.println(ha.key[i] + "  ");
				} else if (ha.key[i] >= 100) {
					System.out.println(ha.key[i] + " ");
				} else {
					System.out.println(ha.key[i] + "  ");
				}
			} else {
				System.out.println("   ");
			}
		}
		 System.out.println();
	 }
	 
	 public int searchHT(Hash ha, int p, int m, int key) {
		 int adr;
		 adr = key%p;
		 while(ha.key[adr] != nullkey && ha.key[adr] != key) {
			 adr = (adr + 1) % m;
		 }
		 if (ha.key[adr] == key) {
			return adr;
		} else {
			return -1;
		}
	 }
}






