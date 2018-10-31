package queue;

/**
 * 队列简称队--他同堆栈一样，也是一种运算受限的线性表，其限制是仅允许在表的一端进行插入，
 * 而在表的另一端进行删除；
 * 在队列中把插入数据元素的一端称为队尾，删除数据元素的一端称为队头；
 * 向队尾插入元素称为进队和入队，新元素入队后成为新的队尾元素；从队列中删除元素称为离队或出队，
 * 元素出队后，其后续元素成为新的队头元素；
 * 由于队列的插入和删除操作分别在队尾和队头进行，每个元素必然按照进入的次序离队，也就是说先进队
 * 的元素必然先离队，所以称队列为先进先出表；
 * 
 * *顺序队列--利用顺序存储方式实现的队列称为顺序队列
 * 
 * @author PW
 * @since 2018/03/12
 *
 */
public class SqeQueue {
	
	/**
	 * 入队
	 * 1、先判断队列是否已经装满元素，如果未装满才能进行入队操作，否则不操作
	 * 2、将要入队的元素放入队尾，队尾指针再自增
	 * 
	 */
	public void add() {
		
	}
	
	/**
	 * 出队
	 * 1、先判断队列是否为空，如果不为空才能进行出队操作，否则不操作
	 * 2、将队头的元素取出，再使队头指针自增
	 * 
	 */
	public void remove() {
		
	}

}
