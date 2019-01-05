import org.junit.Test;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author pp 2019-01-05 20:28
 *
 * 安全的Socket
 *
 * javas.net.ssl
 * javax.net
 * java.security.cert
 * com.sun.net.ssl
 *
 * @see javax.net.ssl.HandshakeCompletedListener
 * @see javax.net.ssl.HandshakeCompletedEvent
 * @see javax.net.ssl.SSLSession
 * @see javax.net.ssl.SSLSocket
 * @see SSLSocketFactory
 * @see javax.net.ssl.SSLServerSocketFactory
 *
 */
public class NetSSLSocketFactory {

    @Test
    public void ssl() throws IOException {
        SocketFactory factory = SSLSocketFactory.getDefault();
        Socket socket = factory.createSocket("127.0.0.1", 22);

        //
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        Socket socket1 = factory.createSocket(inetAddress,80);
        Socket socket2 = factory.createSocket("host", 80, inetAddress, 80);
        Socket socket3 = factory.createSocket(inetAddress,80,inetAddress,80);
//        Socket socket4 = factory.createSocket(new Socket(),"host", 80, true);


       //
//        SSLSession sslSession = socket.getS


    }



}
