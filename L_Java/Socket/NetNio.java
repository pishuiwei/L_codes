import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;

/**
 * @author pp 2019-01-06 00:12
 *
 * @see ByteBuffer
 * @see java.nio.CharBuffer
 *
 */
public class NetNio {

    /**
     *
     * @throws IOException
     *
     * 可以直接写入通道，而不需要像Socket哪像获取输入输出流
     */
    public void sockeChannel() throws IOException {
        SocketAddress socketAddress = new InetSocketAddress("ww.baidu.com",80);
        SocketChannel socketChannel = SocketChannel.open(socketAddress);
        socketChannel.configureBlocking(true);
        //
        ByteBuffer byteBuffer = ByteBuffer.allocate(74);
        int bytesRead = socketChannel.read(byteBuffer);

        WritableByteChannel output = Channels.newChannel(System.out);
        byteBuffer.flip();  // 回绕缓冲区
        output.write(byteBuffer);
        byteBuffer.clear();
    }

    public void servrtSocketChannel() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(19));

        serverSocketChannel.configureBlocking(false);

        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);

        // Selector允许程序迭代处理所有准备好的连接
        Selector selector = Selector.open();
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

        SelectionKey key = socketChannel.register(selector, SelectionKey.OP_ACCEPT);


    }


}








