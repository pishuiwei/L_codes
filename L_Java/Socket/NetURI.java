import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author pp 2018-12-26
 *
 * 统一资源定位符是采用特定语法标识一个资源的字符串
 *
 * 可以包含Unicode字符。
 *
 * URI格式：
 *      模式:模式特定部分
 *
 * @see java.net.URI
 * @see java.net.Authenticator
 * @see java.net.PasswordAuthentication
 * @see javax.swing.JPasswordField
 *
 */
public class NetURI {

    public void constructed() throws URISyntaxException {
        URI uri = new URI("pp://w");
        URI u = new URI("http", "www.ibiblio","/javafaq/index.html");
        URI r = new URI("http", "www.ibiblio","/javafaq/index.html","today");
        URI i = new URI("http", "www.ibiblio","/javafaq/index.html","referrer=cnet&data=2014-02-23","today");
        URI today = new URI("http", "name:pass@xkcd.com","www.ibiblio", 21, "/javafaq/index.html","referrer=cnet&data=2014-02-23","today");

        URI t = URI.create("");

    }

    public void method() throws URISyntaxException {
        URI r = new URI("http", "www.ibiblio","/javafaq/index.html","today");
        //http://www.ibiblio/javafaq/index.html#today

        // 如果是由模式的URI则返回true，如果是无模式的URI则返回false
        System.out.println(r.isAbsolute());
        // 如果URI是一个层次URI时返回false，如果不是分层次的URI则返回true
        System.out.println(r.isOpaque());
        System.out.println(r.resolve("www")); //http://www.ibiblio/javafaq/www
        System.out.println(r.relativize(new URI("sss")));
    }

    /**
     * 编码、解码字符串
     * @throws UnsupportedEncodingException
     */
    public void encoder() throws UnsupportedEncodingException {
        System.out.println(URLEncoder.encode("我","UTF-8")); //对字符串进行编码
        System.out.println(URLDecoder.decode("%E6%88%91","UTF-8")); // 解码字符串
    }

    /**
     * 代理
     */
    public void proxy() {
        System.setProperty("http.proxyHost","192.168.254.254"); //设置代理服务器
        System.setProperty("http.proxyPort","8080");
        System.setProperty("http.nonProxyHosts","java.oreilly.com|xml.oreilly.com");// 禁止代理
    }

}














