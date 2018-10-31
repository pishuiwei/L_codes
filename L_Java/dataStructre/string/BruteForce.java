package string;

/**
 * 串的匹配
 * 
 * @author PW 2018/03/13
 *
 */
public class BruteForce {
	
	/**
	 * Brute-Force（暴风算法）
	 * 从目标串s的第一个字符起和模式串t的第一个字符进行比较，若相等，则继续逐个比较后续字符，
	 * 否则从s串的第二个字符起再重新和串t进行比较。以此类推，直至串t中每个字符依次和串s的一
	 * 个连续的字符序列相等，则称为模式匹配成功，此时串t的第一个字符在串s中的位置就是t在s中
	 * 的位置，否则模式匹配不成功
	 * 
	 * 这种匹配模式的主串指针需要回溯，速度慢
	 * 
	 * @param s 主串
	 * @param t 子串
	 * @param pos 为从哪个位置开始匹配
	 * @return
	 */
	public static int bf(SeqString s, SeqString t, int pos) {
		/* 非法操作  */
		if (pos < 0 || t.curlen < 0 ) {
			return 0;
		}
		int i = pos, j = 0;
		while(i < s.curlen && j <t.curlen) {  
			if(s.data[i] == t.data[j]) { // 相等
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
		}
		if (j >= t.curlen) {
			return i - t.curlen; // 或者i - j + 1
		} else {
			return 0; // 没找到
		}
	}
	
}



