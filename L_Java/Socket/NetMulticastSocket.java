import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @author pp 2018-01-09 22:25
 *
 * @see java.net.MulticastSocket
 * @see java.net.DatagramSocket
 *
 */
public class NetMulticastSocket {

    public void multicast() throws IOException {
        MulticastSocket ms = new MulticastSocket(2300); //在端口2300打开一个主播

        // 加入到组播
        InetAddress group = InetAddress.getByName("224.2.2.2");
        ms.joinGroup(group);

        // 接收来自组播的数据
        byte[] buffer = new byte[8192];
        DatagramPacket bp = new DatagramPacket(buffer, buffer.length);
        ms.receive(bp);

        // 离开组播
        ms.leaveGroup(group);
        ms.close();

        // 向组播地址发送数据
        InetAddress ia = InetAddress.getByName("experiment.mcast.net");
        byte[] data = "Here's some multicast dta\r\n".getBytes("UTF-8");
        int port = 4000;
        DatagramPacket dp = new DatagramPacket(data, data.length, ia, port);
        MulticastSocket multicastSocket = new MulticastSocket();
        ms.send(dp);

    }

}










