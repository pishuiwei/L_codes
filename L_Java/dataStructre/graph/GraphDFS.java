package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * *图的遍历：是树的遍历的推广，从给定图中任意指定的顶点（称为初始点）出发，按照某种搜索方法沿
 * 		着图的边访问图中所有顶点，使每个顶点仅被访问一个，这个过程称为图的遍历，亦是将网络结
 * 		按某种规则线性化的过程。图的遍历方法有两种：深度优先搜索法和广度优先搜索法<br>
 * 
 * 深度优先搜索法：类似于树的先序遍历，它的基本思想是：首先访问指定的起始顶点v，然后选取与v邻接
 * 		的未被访问的任一个顶点w，访问之，在选取与w邻接的未被访问的任一顶点，访问之。重复进行如
 * 		上的访问，当一个顶点所有邻接顶点都被访问过时，则依次退回到最近被访问过的顶点，若它还有邻
 * 		接顶点未被访问过，则从这些未被访问过的顶点取其中的一个顶点开始重复上述访问过程，直到所有
 * 		顶点都被访问过为止<br>
 * 
 * @author PW 2018/03/17
 *
 */
public class GraphDFS {
	static int[][] graph = new int[100][100];
	static int[] visited = new int[100];
	static int n = 6;
	static int predfn,postdfn;
	static List<Integer> queue = new ArrayList<>();
	
	public static void DFS() {
		int flag = 0;
		for(int i =0; i < n; i++) {
			if (visited[i] == 0) {
				flag++;
				dfs(i, flag);
			}
		}
	}
	
	private static void dfs(int i, int flag) {
		visited[i] = 1;
		System.out.println(" " + (char)(i+1+96));
		for (int j = 0; j < n; j++) {
			if (graph[i][j] == 1 && visited[j] == 0) {
				dfs(i, flag);
			}
		}
	}
	
	public static void main(String[] args) {
		graph[0][1] = graph[1][0] = 1; 
		graph[0][3] = graph[3][0] = 1; 
		graph[0][4] = graph[4][0] = 1; 
		graph[1][2] = graph[2][1] = 1; 
		graph[1][4] = graph[4][1] = 1;
		graph[2][4] = graph[4][2] = 1;
		graph[2][5] = graph[5][2] = 1;
		graph[4][5] = graph[5][4] = 1;
		DFS();
	}
	
}




