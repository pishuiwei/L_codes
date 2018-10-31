package collection;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Integer、String、Character
 * 允许重复,最小的拥有最高的优先级
 * 如果是Sting,空格也可以算作值，并且比字母优先级高
 * 
 * @author PP
 * 2017-08-26 21:40
 */
public class PriorityQueueDemo {
	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		Random random = new Random(47);
		for(int i = 0; i < 10; i++) {
			priorityQueue.offer(random.nextInt(i+20));
		}
		QueueDemo.printQ(priorityQueue);
		List<Integer> ints = Arrays.asList(25,22,20,18,14,9,31,1,2,3,9,14,18,21,23,25);
		priorityQueue = new PriorityQueue<Integer>(ints);
		QueueDemo.printQ(priorityQueue);
	}
}
