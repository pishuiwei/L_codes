package string;

/**
 * 串：由零个或多个字符组成的有限序列
 * 两种：串变量和串常量
 * 串变量：是一块内存空间，里面存放的串值可以改变
 * 串常量：只能读不能写
 * 空串：长度为零的串称为空串，它不包含任何字符
 * 空白串：通常将仅由一个或多个空格组成的串称为空白串
 * 
 * 特点：串是由字符元素组成的特殊线性表，串和线性表的存储结构相识，包括顺序存储和链式存储两种
 *  
 * "\0"
 * 
 * *顺序串：串的顺序存储结构方法和线性表一样，即用一组连续的存储单元一次存储串中的字符序列，构成串的顺序存储，简称顺序串
 * *顺序定长的串：串长度超过上限时，只能用截尾法处理
 * @author 2018/03/09 PW
 *
 */
public class SeqString {
	/* 存放字符元素的数组 */
	char[] data = new char[10];
	/* 实际串长 */
	int curlen = 0; 
	
	public void setString(String str) {
		int i = 0;
		curlen = str.length();
		if(curlen > 10) { //超过上限，截取尾部
			curlen = 10;
		}
		for (; i < data.length; i++) {
			data[i] = str.charAt(i);	
		}
		/* 结束标记 */
		data[i] = '\0';
		
	}
	

}
