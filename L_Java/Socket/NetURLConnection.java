import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author pp 2019-01-03 21:47
 *
 * @see java.net.URLConnection
 * @see java.net.URLStreamHandler
 * @see sun.net.www.protocol.file.FileURLConnection
 * @see sun.net.www.protocol.http.HttpURLConnection
 * @see sun.net.www.http.HttpClient
 * @see java.security.Permission
 *
 */
public class NetURLConnection {

    /**
     * 获取一个URLConnection
     *
     * @throws IOException
     */
    public void get() throws IOException {
        URL url = new URL("http://www.baidu.com/");
        URLConnection uc = url.openConnection();

        // 获取数据
        InputStream in = uc.getInputStream();
        int l;
        while( (l = in.read()) != -1) {
            System.out.print((char) l);
        }

        // 响应
        System.out.println(uc.getContentType());
        System.out.println(uc.getHeaderField("content-type")); // 获取指定的首部
        System.out.println(uc.getHeaderField(1));// 获取指定的第n个首部，第一个首部为1
        System.out.println(uc.getHeaderFieldKey(1)); // 获取第n个首部的key

        // 缓存 Cache-control 、Expires
        // ResponseCache
        // CacheRequest
        // CacheResponse

        // 请求
        uc.setRequestProperty("Cache-Control","no-cache"); // 设置请求首部
        uc.addRequestProperty("Content-Type","text/html"); // 为同一个首部追加内容

        // 向服务器写数据
        uc.setDoOutput(true);
        uc.getOutputStream();

        URLConnection.guessContentTypeFromName("");
        URLConnection.guessContentTypeFromStream(uc.getInputStream());
    }

    @Test
    public void httpURLConnection() throws IOException {
        URL url = new URL("http://www.baidu.com/");
        HttpURLConnection huc = (HttpURLConnection)url.openConnection();

        huc.setRequestMethod("POST"); //设置请求方法
        huc.setRequestProperty("Cache-Control","no-cache");
        huc.setDoInput(true);
        huc.setDoOutput(true);
        huc.setConnectTimeout(10000);
        huc.setReadTimeout(1000);

//        huc.disconnect(); // 关闭连接
        System.out.println(huc.usingProxy()); // 是否使用代理

    }

}
