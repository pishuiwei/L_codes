import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author pp 2018-12-26
 *
 * URL是最常见的URI,除了标识一个资源，还会为资源提供一个特定的网络位置，客户端可以用
 * 他来获取这个资源的一个表示。与之不同的是，通用的URI可以告诉你一个资源时什么，但是
 * 无法告诉你他在哪里。
 *
 *  URL组成部分：
 *      模式（协议）、授权机构、路径、片段标识（段、ref）、查询字符串
 *
 * @see java.net.URL
 *  URL(String url)
 *  URL(String protocol,String hostname,String file) throws MalformedURLException
 *  URL(String protocol, String host, int port, String file) throws MalformedURLException
 *  URL(URL base，String relative)
 *
 */
public class NetURL {

    /**
     * 创建一个URL
     */
    @Test
    public void url() throws IOException {
        URL url = new URL("https://www.baidu.com");
        URL url1 = new URL(url,"test"); //https://www.baidu.com/test

        InputStream in = url.openStream();
        URLConnection urlConnection = url.openConnection();

        Object o = url.getContent(); // 获取由URL引用的数据，尝试由它建立某种类型的对象
        Object o1 = url.getContent(new Class[]{});


        System.out.println("o:" + o.getClass().getName());

    }

    /**
     * 常用get方法
     */
    public void getMethod() throws MalformedURLException {
        URL url = new URL("https://name:pass@xkcd.com/727/123?user=name#ref");

        System.out.println(url.getProtocol());  // 获取URL的模式[https]
        System.out.println(url.getHost());      // 获取主机名[xkcd.com]
        System.out.println(url.getPort());      // 获取url指定的端口，没指定则返回-1
        System.out.println(url.getDefaultPort());// 获取模式的默认端口[443]
        System.out.println(url.getFile());      // 获取URL的路径部分
        System.out.println(url.getPath());      // 不包括查询查询字符串，只有路径
        System.out.println(url.getRef());       // 获取URL的片段标识ref
        System.out.println(url.getQuery());     // 返回URL的查询字符串
        System.out.println(url.getUserInfo());  // 返回URL中的用户信息
        System.out.println(url.getAuthority()); // 返回授权机构，包含用户信息
    }

    /**
     * equals()方法会尝试用DNS解析主机，来判断两个主机是否相等，
     * 所以可能是一个阻塞的I/O操作。
     * 但是不会具体比较两个URL标识的资源，例如：
     * http://www.oreilly.com与http://www.oreilly.com/index.html不相等
     *
     * sameFile()方法比较两个URL，但是不考虑片段标识
     */
    public void equalsAndSameFile() {

    }

    @Test
    public void transFrom() throws MalformedURLException, URISyntaxException {
        URL url = new URL("http://www.baidu.com");

        System.out.println(url.toString());     // 返回URL的绝对值
        System.out.println(url.toExternalForm());// 返回URL的绝对值
        System.out.println(url.toURI());        // 把URL转化为URI对象
    }

    /**
     * 通过URL获取输入流读取地址返回的内容
     */
    public void getResource() throws IOException {
        URL url = new URL("https://www.baidu.com");
        InputStream in = url.openStream();

        int c;
        while((c = in.read())!= -1) System.out.write(c);
        in.close();
    }

}
