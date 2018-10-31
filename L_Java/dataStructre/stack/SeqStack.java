package stack;

/** 
 * 栈(堆栈) -- 是限定在表的一端进行插入和删除的线性表；
 * 其限制是仅允许在表的一端进行插入和删除，不允许在其他任何位置进行插入、查找、删除等操作；
 * 表中进行插入、删除操作的一端称为栈顶，栈顶保存的元素称为栈顶元素。相对的，表的另一端称为栈底。
 * 当栈中没有数据元素时称为空栈；向一个栈插入元素又称为进栈和出栈；从一个栈中删除元素又称为出栈或退栈。
 * 由于栈的插入和删除操作仅在栈顶进行，后进栈的元素必定先出栈，所以又把堆栈称为后进先出表。
 * 
 * *顺序栈 -- 由于栈是运算受限的线性表，除了操作不同外，线性表的存储结构对栈也是适用的。
 * 
 * @author PW 
 * @since 2018/03/01
 *
 */
public class SeqStack {
	private Student[] data; //存放学生表个数据元素的数组
	private int length; //栈的长度
	private int top; //栈顶指针
	
	public SeqStack() {
		data = new Student[35];
		length = 35;
		top = -1;
	}
	
	/**
	 * 入栈
	 * 1、先判断是否已经装满元素，如何未装满才能进行入栈操作，否则不操作
	 * 2、栈顶指针先自增，给需要进栈的元素腾出内存空间
	 * 3、在将要入栈的元素放入腾出的内存空间里，就是把入栈的元素赋值给对应的数组元素
	 * @param stu
	 */
	public boolean push(Student stu) {
		boolean bRest = false;
		if(top >= -1 && top < length-1) {
			top++;
			data[top] = stu;
			System.out.println("入栈:" + stu.toString());
			bRest = true;
		}
		return bRest;
	}
	
	/**
	 * 出栈
	 * 1、先判断是否有元素，如果有元素时才能进行出栈操作，否则不操作
	 * 2、再将要出栈的元素放入内存空间里
	 * 3、栈顶指针自减
	 * @return Student
	 */
	public Student pop() {
		Student stu = null;
		if(top > 0 && top < length) {
			stu = data[top];
			System.out.println("出栈：" + stu.toString());
			top--;
		}
		return stu;
	}
}


/**
 * 学生类
 * @author pp
 *
 */
class Student{
	String name = "pw";
	String no = "1";
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", no=" + no + "]";
	}
	
}
