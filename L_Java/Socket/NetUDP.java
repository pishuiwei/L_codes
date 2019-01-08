import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Date;

/**
 * @author pp 2019-01-08 21:26
 * 学习UDP
 *
 * 客户端与服务器端只是发送和接收数据的顺序不同
 *
 * @see java.net.DatagramSocket
 * @see java.net.DatagramPacket
 * @see java.nio.channels.DatagramChannel
 *
 */
public class NetUDP {

    public void client() throws IOException {
        DatagramSocket socket = new DatagramSocket(0); //在本地能使用的端口上打开一个socket
        socket.setSoTimeout(10000);

        // 要发送的数据
        InetAddress host = InetAddress.getByName("127.0.0.1");
        DatagramPacket request = new DatagramPacket(new byte[1],1, host, 8090);

        // 要接受的数据
        byte[] data = new byte[1024];
        DatagramPacket response = new DatagramPacket(data, data.length);

        //
        socket.send(request); // 发送数据
        socket.receive(response); // 接受数据

        // 显示获取到的数据
        String daytime = new String(response.getData(),0, response.getLength(),"US-ASCII");
        System.out.println(daytime);
    }

    public void server() throws IOException {
        DatagramSocket socket = new DatagramSocket(8090); //在指定端口打开一个socket

        // 创建一个接收请求的数据包
        DatagramPacket request = new DatagramPacket(new byte[1024], 0, 1024);
        // 接收这个数据包，这个调用会无限阻塞，直到一个UDP数据包到达端口13
        // 如果有UDP数据包到达，Java就会将这个数据填充在byte数组中，receive()方法返回
        socket.receive(request);

        // 创建一个相应数据包
        String daytime = new Date().toString() +"\r\n";
        byte[] data = daytime.getBytes();
        InetAddress host = request.getAddress();
        int port = request.getPort();
        DatagramPacket response = new DatagramPacket(data, data.length, host, port);
        // 发送响应
        socket.send(response);
    }

    public void channel() throws IOException {
        DatagramChannel channel = DatagramChannel.open(); // 打开一个socket

        // 绑定通道到指定端口
        SocketAddress address = new InetSocketAddress(3141);
        channel.bind(address);

        // 接收数据,receive()会把接收到的数据放入buffer
        ByteBuffer buffer = ByteBuffer.allocate(65507);
        SocketAddress client =channel.receive(buffer);

        // 发送数据
        channel.send(buffer, client);

        // 连接
        channel.connect(client);
        // 关闭
        channel.close();
        // 读取
        channel.read(buffer);
        // 写入
        channel.write(buffer);

    }


}


















