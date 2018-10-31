package graph;

/**
 * *最小生成树<br>
 * 1、生成树<br>
 * 无回路的图称为树或自由树或无根数。若连通图G有n个顶点，取G中n个顶点，取连接n个顶点的
 * n-1条边且无回路的子图称为G的生成树。满足这个定义的生成树可能有多棵，即生成树不唯一<br>
 * 在对具有n个顶点的连通图进行遍历时，要访问图中的所有顶点，在访问n个顶点过程中一定经过n-1
 * 条边，由深度优先遍历和广度优先遍历所经过的n-1条边是不同的，通常把由深度优先遍历所经过的
 * n-1条边和n个顶点组成的图形称为深度优先生成树。而由广度优先遍历所经过的n-1条边和n个顶点 组成的图形称为广度优先生成树<br>
 * 2、最小生成树<br>
 * 图的生成树不是唯一的，也即一个图可以产生若干棵生成树。对于带边权的图来说同样可以有许多生成树，
 * 通常把树中边权之和定义为树的权，则在所有生成树中树权最小的那棵生成树就是最小生成树<br>
 * <br>
 * 求最小生成树的基本算法有普里姆算法和克鲁斯卡尔算法两种
 * 
 * @author PW 2018/03/17
 *
 */
public class MST {
	
	/**
	 * 
	 *  ##*##
	 *	#*#*#
	 *	*###*
	 *	#*#*#
	 *	##*##
     *
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 3;
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num - i; j++) {
				System.out.print("#");
			}
			for (int k = 1; k <= 2 * i - 1; k++) {
				if (k == 1 || k == 2 * i - 1) {
					System.out.print("*");
				} else {
					System.out.print("#");
				}
			}
			for (int j = 1; j <= num - i; j++) {
				System.out.print("#");
			}
			System.out.println();
		}

		for (int i = 1; i < num; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("#");
			}
			int count = 2 * (num - i) - 1;
			for (int k = 0; k < count; k++) {
				if (k == 0 || k == count - 1)
					System.out.print("*");
				else
					System.out.print("#");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("#");
			}
			System.out.println("");
		}
	}
}
