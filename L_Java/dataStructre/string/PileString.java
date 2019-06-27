package string;

/**
 * 串的堆存储及实现
 * 堆存储结构的基本思想：在内存中开辟一个地址连续且足够大的存储空间作为应用程序中所有串的可利用空间，称之为堆空间；
 * 每个串在堆空间里占用的存储区域的大小都是动态的，如果一个串在操作过程中发现原空间不足，可以根据需要重新申请更大
 * 的存储空间，赋值原串到新的存储空间后再释放原空间
 * 
 * 
 * @author PW 2018/03/13
 *
 */
public class PileString {
	/* 存放字符元素的数组 */
	char[] data;
	/* 实际串长 */
	int curlen = 0;
	
	public void setString(String str) {
		int n = 0;
		curlen = str.length();
		data = new char[curlen+1];
		for(; n < curlen; n++) {
			data[n] = str.charAt(n);
		}
		/* 结束标识 */
		data[n] = '\0';
	}
	
	/**
	 * 判断是否是回文
	 * 第i个字符==sources.length()-i-1;
	 * 
	 * @return
	 */
	public boolean isHuiWei() {
		int i, j; // i,j为前后部分索引的位置
		int k; // 比较次数
		i = 0; // 第一个位置
		j = curlen - 1; //最后一个位置
		
		for(k = 1; k <= curlen/2; k++,i++,j--) {
			if (data[i] != data[j]) {
				return false;
			}
		}
		return true;
	}
	
}


