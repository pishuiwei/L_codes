package _note;

import org.junit.Test;

/**
 * @author pp
 *
 * 用于记录一些常用的API
 *
 */
public class AUp {

    @Test
    public void get(){
        System.setProperty("http.proxyHost","http://www.baidu.com"); //设置系统的全局变量
        System.getProperty("http.proxyHost");   // 获取系统属性
    }

}