package collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 先进先出
 * 从容器的一端放入事物,从另一端取出
 * offer() 将一个元素插入到队尾,或者返回false
 * peek()和element() 都是返回队列的第一个，peek()返回null,element()抛出异常
 * poll()和remove() 移除并返回队头，poll()返回null,element()抛出异常
 * 
 * @author PP
 * 2017-08-26 
 *
 */
public class QueueDemo {
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Random random = new Random(47);
		for(int i = 0; i < 10; i++) {
			queue.offer(random.nextInt(i+10));
		}
		printQ(queue);
		System.out.println();
		Queue<Character> qc = new LinkedList<Character>();
		for(char c : "Brontosaurus".toCharArray()) {
			qc.offer(c);
		}
		printQ(qc);
	}

	public static void printQ(Queue<?> queue) {
		while(queue.peek()!=null) {
			System.out.print(queue.remove() + " ");
		}
	}
}
