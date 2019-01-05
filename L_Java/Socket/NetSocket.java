import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @author pp 2019-01-05
 *
 * @see Socket
 */
public class NetSocket {

    /**
     * /etc/services
     * TCP_NODELAY
     * SO_BINDADDR
     * SO_TIMEOUT
     * SO_LINGER
     * SO_SNDBUF
     * SO_RCVBUF
     * SO_KEEPALIVE
     * OBBINLINE
     * OP_TOS
     *
     * whois服务器
     */
    @Test
    public void connection() {
        try {
            Socket socket = new Socket("www.baidu.com", 80);
            socket.setSoTimeout(15000);

            System.out.println("连接的地址：" + socket.getRemoteSocketAddress());
            System.out.println("发起连接的地址：" + socket.getLocalSocketAddress());

            if (socket.isConnected()) {

                // 写入服务器
                OutputStream ot = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(ot, true);
                printWriter.println("GET / HTTP/1.1");
                printWriter.println("Host: www.baidu.com:80");
                printWriter.println("\r\n");

                // 读取服务器
                InputStream in = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String l;
                while ((l = br.readLine()) != null) {
                    System.out.println(l);
                }

            }
                socket.shutdownInput();
                socket.shutdownOutput();
                socket.isInputShutdown();
                socket.isOutputShutdown();

            } catch(IOException e){
                e.printStackTrace();
            }
    }

    public void socket() throws IOException {
        InetAddress inetAddress = InetAddress.getByName("");
        SocketAddress socketAddress = new InetSocketAddress("www.baidu.com",80);

        Socket socket = new Socket("",80);
        Socket socket1 = new Socket(inetAddress, 80);
        Socket socket2 = new Socket(); //
        socket2.connect(socketAddress,1000);

        Socket socket3 = new Socket(); // Proxy
        Socket socket4 = new Socket(); // SocketImpl
        Socket socket5 = new Socket("",80, inetAddress, 80);
        Socket socket6 = new Socket(inetAddress,80, inetAddress, 80);
    }

    public void getHttp() throws IOException {
        System.out.println(InetAddress.getByName("www.baidu.com"));
        Socket s = new Socket(InetAddress.getByName("www.baidu.com"), 80);
        if (s.isConnected()) {
            System.out.println(s.getInetAddress());
            System.out.println("客户端已经连上");
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                out.println("GET / HTTP/1.1");
                out.println("Host: www.baidu.com:80");
                out.println("\r\n");

                String line = "";

                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                br.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
