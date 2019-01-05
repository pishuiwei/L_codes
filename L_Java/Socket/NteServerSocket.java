import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;

/**
 * @author pp 2018-01-05 19:41
 *
 * @see ServerSocket
 * @see java.util.logging.Logger
 * @see com.sun.net.httpserver.HttpHandler
 */
public class NteServerSocket {

    public void init() throws IOException {
        // 方法一
        ServerSocket server = new ServerSocket(80);
        Socket socket = server.accept();

        // 方法二
        ServerSocket serverSocket = new ServerSocket();
        SocketAddress socketAddress = new InetSocketAddress(80);
        server.bind(socketAddress, 50);

        // 方法三
        ServerSocket serverSocket1 = new ServerSocket(80,50); //最多50个入站连接

        // 方法四
        InetAddress local = InetAddress.getByName("192.168.201.122");
        ServerSocket serverSocket2 = new ServerSocket(80,50,local);

        // 常用方法
        server.isClosed();
        server.isBound();
        server.getInetAddress();//获取服务器本地地址
        server.getLocalPort(); //获取服务器绑定端口
        server.setSoTimeout(15000);
        server.setReuseAddress(true);
        server.setReceiveBufferSize(1024);
        server.setPerformancePreferences(2,1,3);
        //
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        writer.println("HTTP/1.1 200 OK");
        writer.println();
    }

    @Test
    /**
     * 一个简单的web服务器
     */
    public void httpServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        Socket socket = serverSocket.accept();

        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-type: text/html");
        writer.println("\r\n");
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\">");
        writer.println("<title>Insert title here</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("    <p>欢迎</p> ");
        writer.println("</body>");
        writer.println("</html>");
        writer.flush();

        System.out.println("响应成功!");

    }


}
