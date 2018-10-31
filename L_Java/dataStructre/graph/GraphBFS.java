package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * *广度（宽度）优先搜索：广度优先遍历类似于树的层次遍历，它的基本思想是：首先访问指定指定的起始顶点v，
 * 		然后选取与v邻接的全部顶点w1，w2，...wt，再依次访问与w1,w2,...wt邻接的全部顶
 * 		点（已被访问的顶点除外）， 再从这些被访问的顶点出发，逐次访问与它们邻接的全部顶点（已被访问
 * 		的顶点除外）。依次类推，直到所有顶点都被访问为止。
 * 
 * @author PW 2018/03/17
 *
 */
public class GraphBFS {
	static int[][] graph = new int[100][100];
	static int[] visited = new int[100];
	static int n = 6;
	static int predfn,postdfn;
	static List<Integer> queue = new ArrayList<>();
	
	public static void BDF() {
		int flag = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				flag++;
				bfs(i, flag);
			}
		}
	}
	
	public static void bfs(int i, int flag) {
		visited[i] = 1;
		queue.add(i);
		System.out.println(" " + (char)(i+1+96));
		while(!queue.isEmpty()) {
			int v = queue.remove(queue.size() - 1);
			for (int j = 0; j < n; j++) {
				if (graph[v][j] == 1 && visited[j] == 0) {
					visited[j] = 1;
					queue.add(j);
					System.out.println(" " + (char)(j+1+96));
				}
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
		BDF();
	}
	
}
