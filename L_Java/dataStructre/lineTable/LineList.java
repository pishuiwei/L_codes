package lineTable;

/**
 * *线性表（线性结构）-- 顺序表
 * 线性表是由同一类型数据元素组成的有限序列
 * 
 * 顺序表的概念：
 *		顺序表示是指按顺序存储结构存储的线性表,顺序存储表中的结点在内存中占用一段连续的存储单元。
 *		即线性表中逻辑相邻的元素在内存中存储位置相邻。
 * 顺序表优点：
 * 		方法简单，各种高级语言中都有数组，容易实现
 * 		不用为表示结点间的逻辑关系而增加额外的存储开销，存储密度大
 * 		顺序表具有按元素序号随机访问的特点，查找速度快，时间复杂度较小
 * 顺序表的缺点：
 * 		在顺序表中进行插入、删除操作时，平均移动大约表中一半的元素，因此n较大的顺序表执行效率低
 * 		需要预先分配适当的存储空间，预先分配过大，可能导致顺序表的后部大量闲置；预先分配过小，又会造成溢出
 * 
 * @author PW 2018/01/12
 *
 */
public class LineList<T> {
	
	int length = 10;//表长度
	public Object[] data = new Object[length];//存放的数据
	int curlen = 0;//实际表长度
	
	/**
	 * 在指定位置插入数据元素
	 * 
	 * 1、从位置i+1到表尾位置的所有数据元素均要向前移动一个存储位置，则原来第i+1个结点覆盖第i个结点；
	 * 2、将新结点插入到空余位置i处；
	 * 3、修改表长度，使之增加1。
	 * 
	 * @param t 
	 * @param i 
	 * 
	 */
	public void insert(T t, int i) {
		// 判断插入的位置是否正确
		if(i < 0 || i > length || curlen >= length) {
			System.out.println("插入的位置不对或表已经存满");
			return;
		}
		// 循环个插入位腾出空间
		for (int j = curlen; j > i; j--) {
			data[j] = data[j - 1];
		}
		data[i] = t;
		curlen++;
	}
	
	/**
	 * 删除指定位置的数据
	 * 
	 * 从位置i+1到表尾位置的所有数据元素均要向前移动一个存储位置，则原来第i+1个结点覆盖第i个结点，
	 * 以此内推，直到表的尾则可实现第i个结点的删除；
	 * 修改表的长度，使之减1。
	 *	
	 * @param i
	 * @return
	 */
	public Object delete(int i) {
		if(i < 0 || i > curlen) {
			System.out.println("删除位置不正确");
			return null;
		}
		
		// 从i开始循环覆盖元素
		for (int j = i; j >= i; j--) {
			data[i] = data[i+1];
		}
		curlen--;
		data[curlen] = null;
		return data[i];
	}
	
	public static void main(String[] args) {
		LineList<String> lineList = new LineList<>();
		lineList.insert("a", 0);
		lineList.insert("b", 1);
//		Object[] objects = lineList.data;
//		for(Object o : objects) {
//			System.out.println(o);
//		}
		
		Object object = lineList.delete(0);
		System.out.println(object);
		Object[] objects = lineList.data;
		for(Object o : objects) {
			System.out.println(o);
		}
	}
	
}



