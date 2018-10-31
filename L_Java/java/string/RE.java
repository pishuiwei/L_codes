package string;

import java.util.regex.Pattern;

/**
 * <p>正则表达式
 * \\插入正则表达式中的反斜线
 * \\\\插入Java中的普通反斜线
 * 
 * string.matches("正则表达式") 判断String是否匹配
 * split() 分隔字符<br>
 * 
 * [...] 匹配其中的一个,[1-9] 匹配1-9; 
 * [^...] 匹配任何为列出的字符; [^1-6] 匹配除了1-6的字符;
 * . 匹配任意字符
 * | 匹配 a|b 中的一个
 * ？ 之前相邻的元素出现一次或者不出现 e:w? 有w或者没有(单个元素)
 * + 之前相邻的元素出现一次或多次(单个元素)
 * * 之前相邻的元素出现任意多次,或者不出现(单个元素)
 * {min,max} 重复出现的区间 min~max
 * {min} 出现min此
 * () 表示分组
 * \ 使作用的元字符会失去特殊意义,成为普通的字符
 * & 表示并且
 * 
 * \d 匹配[0-9]
 * \D 匹配[^0-9]
 * \w 匹配[a-zA-Z0-9]
 * \w 匹配[^a-zA-Z0-9]
 * \s 匹配[\t\n\f\r]
 * \S 匹配[^\t\n\f\r]
 * 
 * ^ 匹配一行的开始,e：^cat,以cat开始<br>
 * $ 匹配一行的结尾,e:cat$,以cat结束<br>
 * ^cat$ 匹配只有cat的行,^$ 匹配空行 
 * \b 表示单词结尾
 * 
 * 
 * 
 * 
 * @author PP
 * 2017-09-04 21:54
 */
public class RE {
	private  Pattern pa;
	
	
	public void pattern() {
		// 构建表达式
		pa = Pattern.compile("正则表达式");
		// matches 指匹配的方式
		pa.matcher("要进行匹配的字符").matches();
	}
	
	public static void main(String[] args) {
		System.out.println("\04236");
	}
}
