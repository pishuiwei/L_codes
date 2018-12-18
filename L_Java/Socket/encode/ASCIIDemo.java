package encode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;

public class ASCIIDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        changeUTF8();

        changeCharStringByte();
    }

    /**
     *  String、char、byte之间的相互转换
     */
    public static void changeCharStringByte() throws UnsupportedEncodingException {
        String my = "汉";
        char c ='汉';

        // 字符转化为int
        System.out.println("c:" + (int)c);  // 27721

        // 把字符串转化为指定编码格式的字节数组
        System.out.println(Arrays.toString(my.getBytes("UTF-8"))); //[-26,-79,-119]

        // 字节数组转化为字符串
        System.out.println(new String(my.getBytes("ISO8859-1")));
    }

    /**
     * 把UFT-8编码的字符转化成汉字
     * @throws UnsupportedEncodingException
     */
    public static void changeUTF8() throws UnsupportedEncodingException {
        String str = "%E6%98%9F%E6%9C%9F%E5%87%A0";
        String  chiStr = URLDecoder.decode(str,"UTF-8");

        System.out.println(chiStr);
    }


}
