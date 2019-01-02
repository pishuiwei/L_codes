/**
 *
 * @author pp 2019-01-02 23:12
 *
 * 超文本传输协议，是Web浏览器和Web服务器之间通信的标准协议。
 *
 *
 *
 * @see
 */
public class HTTP {

    /**
     * 请求的基本形式：一个首部行、一个包含元数据的HTTP首部、一个空行，然后是一个消息体
     * 关键字不区分大小写
     * http://www.iana.org/assignments/media-types
     *
     * GET /index.html HTTP/1.1
     * User-Agent: Mozilla/5.0
     * Host:en.wi.com
     * Connection:keep-alive
     * Accept: text-html,application/xhtml+xml(告诉服务器客户端可以处理那些数据类型)
     * Accept-Language:en-Us,en;q=0.5
     * Accept-Encoding:gzip,deflate
     *
     * CONTENT
     */
    public void request() {

    }

    /**
     * 响应的基本形式
     *
     * HTTP/1.1 200 OK
     * Date: Sun,21 pr 2013 15:12:46 GMT
     * Server: Apache
     * Connection: close
     * Content-Type: text/html;charset=ISO-8859-1
     * content-length: 115
     * CONTENT
     *
     */
    public void response() {}



}
