package stack;

/**
 * *递归--是指在定义自身的同时又出现了对自身的引用；
 * 如果一个算法直接或者间接地调用自己，则称这个算法是一个递归算法；
 * 任何一个又意义的递归算法总是有两部分组成：递归调用与递归终止条件
 * 
 * @author PW
 * @since 2018/03/12
 */
public class MyFac {

	/**
	 * 求n!
	 * 
	 * @param n
	 * @return
	 */
	public static long fac(int n) {
		if(n == 0) {
			return 1;
		} else {
			return n*fac(n - 1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(MyFac.fac(3));
	}
	
}
