import java.io.IOException;
import java.net.*;
import java.util.List;

/**
 * @author pp 2019-01-02 22:48
 *
 * @see java.net.Proxy
 */
public class NetProxy {

    public void address() {
        // 表示proxy.example.com的端口80上的一个HTTP代理服务器
        SocketAddress address = new InetSocketAddress("proxy.example.com",80);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, address);
    }

    /**
     *  每个运行中的虚拟机都有一个java.net.ProxySelector对象，
     *  用来确定不同连接的代理副武器
     */
    public void proxySelector() {
        ProxySelector selector = new ProxySelector() {
            @Override
            public List<Proxy> select(URI uri) {
                return null;
            }

            @Override
            public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {

            }
        };

        ProxySelector.setDefault(selector);

    }

}
