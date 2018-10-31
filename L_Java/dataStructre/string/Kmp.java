package string;

/**
 * 串的匹配
 * 
 * @author PW 2018/03/13
 *
 */
public class Kmp {
	
	
	public static void main(String[] args) {
		System.out.println(Kmp.kmp("bacbababadababacambabacaddababacasdsd", "ababaca", Kmp.next("ababaca")));
	}

	/**
	 * 
	 */
	public static int kmp(String str, String sub, int[] next) {
		char[] parent = str.toCharArray(); // 主串
		char[] children = sub.toCharArray(); // 模式串
		
		int k = -1; // 模式串在主串中的位置，默认-1不存在
		
		for (int i = 0; i < parent.length; i++) {
			
			// children和parent不匹配，且k>-1（表示children和parent有部分匹配）
			while (k > -1 && children[k+1] != parent[i]) {
				k = next[k]; //往前回溯
			}
			
			if (children[k+1] == parent[i]) { 
				k = k + 1;
			}
			
			if (k == children.length - 1) { //说明k移动到children的最末端
				return i - children.length + 1;
			}
		}
		return -1;
	}
	
	/**
	 * 偏移函数
	 * 
	 * a  ab 	aba 	abab 	ababa 	ababac 			ababaca
	 * a    ab    aba	  abab	  ababa       ababac	      ababaca
	 * 
	 * @param sub
	 * @return
	 */
	public static int[] next(String sub) {
		int[] next = new int[sub.length()]; 
		next[0] = -1;	// 第一个一定没有最优前缀和最优后缀相等
		char[] str = sub.toCharArray();
		int i = 1; // 后缀标识
		int k = -1; //前缀标识(也是最优前后缀相同部分的长度)
		
		for (i = 1; i < sub.length(); i++) {
			while (k > -1 && str[k+1] != str[i]) {
				k = next[k];
			}
			if (str[k+1] == str[i]) {
				k = k + 1;
			}
			next[i] = k; // 计算出来的最优前后缀相同部分的长度
		}
		return next;
	}
	
}
