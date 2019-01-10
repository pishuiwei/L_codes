package nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Future;

/**
 * @author pp 2019-01-10 21:57
 * @see Channel
 * @see FileChannel
 * @see DatagramChannel
 * @see SocketChannel
 * @see ServerSocketChannel
 *
 * @see Channels
 *
 * @see java.nio.Buffer
 * @see ByteBuffer
 * @see java.nio.CharBuffer
 * @see java.nio.DoubleBuffer
 * @see java.nio.FloatBuffer
 * @see java.nio.IntBuffer
 * @see java.nio.LongBuffer
 * @see java.nio.ShortBuffer
 * @see java.nio.MappedByteBuffer
 *
 * @see Selector
 * @see SelectionKey
 */
public class Nio {
    private RandomAccessFile aFile = new RandomAccessFile("src/nio/Nio.java", "rw");
    private FileChannel inChannel = aFile.getChannel();

    public Nio() throws FileNotFoundException {
    }

    public static void main(String[] args) throws IOException {
        Nio nio = new Nio();
        nio.path();
    }

    /**
     * Java NIO的通道类似流，但又有些不同：
     * 既可以从通道中读取数据，又可以写数据到通道。但流的读写通常是单向的。
     * 通道可以异步地读写。
     * 通道中的数据总是要先读到一个Buffer，或者总是要从一个Buffer中写入
     */
    public void channel() throws IOException {
        // 打开一个通道
        RandomAccessFile aFile = new RandomAccessFile("src/nio/Nio.java", "rw");
        FileChannel inChannel = aFile.getChannel();

        // 创建一个缓冲区
        ByteBuffer buf = ByteBuffer.allocate(48);

        // 读取缓冲区的内容
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();

    }

    /**
     * Java NIO中的Buffer用于和NIO通道进行交互。
     * 如你所知，数据是从通道读入缓冲区，从缓冲区写入到通道中的。
     *
     * 缓冲区本质上是一块可以写入数据，然后可以从中读取数据的内存。
     * 这块内存被包装成NIO Buffer对象，并提供了一组方法，用来方便的访问该块内存。
     *
     * 使用Buffer读写数据一般遵循以下四个步骤：
     * 1.写入数据到Buffer
     * 2.调用flip()方法（切换到读模式）
     * 3.从Buffer中读取数据
     * 4.调用clear()方法或者compact()方法（让缓冲再次可写）
     *
     * capacity
     * 作为一个内存块，Buffer有一个固定的大小值，也叫“capacity”.
     * 你只能往里写capacity个byte、long，char等类型。一旦Buffer满了，
     * 需要将其清空（通过读数据或者清除数据）才能继续写数据往里写数据。
     *
     * position
     * 当你写数据到Buffer中时，position表示当前的位置。初始的position值为0.
     * 当一个byte、long等数据写到Buffer后， position会向前移动到下一个可插入
     * 数据的Buffer单元
     *
     * limit
     * 在写模式下，Buffer的limit表示你最多能往Buffer里写多少数据。
     * 写模式下，limit等于Buffer的capacity。
     * 当切换Buffer到读模式时， limit表示你最多能读到多少数据。因此，
     * 当切换Buffer到读模式时，limit会被设置成写模式下的position值。
     * 换句话说，你能读到之前写入的所有数据（limit被设置成已写数据的数量，
     * 这个值在写模式下就是position）
     */
    public void buffer() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.put((byte) 123);// 写入一个字节的数据
        buffer.get(); // 去读buffer中的数据
        buffer.rewind();// 将position设回0，所以你可以重读Buffer中的所有数据。
                        // limit保持不变，仍然表示能从Buffer中读取多少个元素（byte、char等）。
        buffer.mark();  // 通过调用Buffer.mark()方法，可以标记Buffer中的一个特定position。
                        // 之后可以通过调用Buffer.reset()方法恢复到这个position
        buffer.reset();

        // 打开一个通道
        RandomAccessFile aFile = new RandomAccessFile("src/nio/Nio.java", "rw");
        FileChannel inChannel = aFile.getChannel();

        // 写入数据到通道
        int bytesWrite = inChannel.write(buffer);

    }

    /**
     * Java NIO开始支持scatter/gather，scatter/gather用于描述从Channel
     * 中读取或者写入到Channel的操作
     *
     * scatter(分散):从Channel中读取是指在读操作时将读取的数据写入多个buffer中。
     * 因此，Channel将从Channel中读取的数据“分散（scatter）”到多个Buffer中。
     *
     * gather(聚集):写入Channel是指在写操作时将多个buffer的数据写入同一个Channel，
     * 因此，Channel 将多个Buffer中的数据“聚集（gather）”后发送到Channel。
     *
     *
     */
    public void scatterGather() throws IOException {

        // Scattering Reads 是指数据从一个channel读取到多个buffer中
        // 注意buffer首先被插入到数组，然后再将数组作为channel.read()
        // 的输入参数。read()方法按照buffer在数组中的顺序将从channel
        // 中读取的数据写入到buffer，当一个buffer被写满后，channel紧
        // 接着向另一个buffer中写.
        // Scattering Reads在移动下一个buffer前，必须填满当前的buffer，
        // 这也意味着它不适用于动态消息.
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body   = ByteBuffer.allocate(1024);
        ByteBuffer[] bufferArray = { header, body };
        inChannel.read(bufferArray);

        // Gathering Writes是指数据从多个buffer写入到同一个channel.
        // buffers数组是write()方法的入参，write()方法会按照buffer
        // 在数组中的顺序，将数据写入到channel，注意只有position和limit
        // 之间的数据才会被写入。因此，如果一个buffer的容量为128byte，但是
        // 仅仅包含58byte的数据，那么这58byte的数据将被写入到channel中。
        // 因此与Scattering Reads相反，Gathering Writes能较好的处理动态消息。
        ByteBuffer headers = ByteBuffer.allocate(128);
        ByteBuffer bodys   = ByteBuffer.allocate(1024);
        ByteBuffer[] bufferArrays = { headers, bodys };
        inChannel.write(bufferArrays);
    }

    /**
     * 在Java NIO中，如果两个通道中有一个是FileChannel，那你可以直接将数据从一个channel（
     * 传输到另外一个channel。
     *
     * transferFrom()方法可以将数据从源通道传输到FileChannel通道中。
     * transferTo()方法将数据从FileChannel传输到其他的channel中。
     *
     */
    public void dataTransferBetweenChannels() throws IOException {
        // transferFrom()
        // 数据的来源
        RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();
        // 要写入的地方
        RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
        FileChannel toChannel = toFile.getChannel();
        //
        long position = 0;
        long count = fromChannel.size();
        // 把fromChannel的数据写入toChannel
        toChannel.transferFrom(fromChannel, position, count);

        // transferTo()
        //
        RandomAccessFile fromFile1 = new RandomAccessFile("fromFile.txt", "rw");
        FileChannel      fromChannel1 = fromFile1.getChannel();
        //
        RandomAccessFile toFile1 = new RandomAccessFile("toFile.txt", "rw");
        FileChannel      toChannel1 = toFile1.getChannel();
        //
        long position1 = 0;
        long count1 = fromChannel.size();
        // 把fromChannel1的数据传入到toChannel1
        fromChannel1.transferTo(position1, count1, toChannel1);
    }

    /**
     * @see Selector
     *
     * 使用selector可以管理多个通道。
     * Selector（选择器）是Java NIO中能够检测一到多个NIO通道，
     * 并能够知晓通道是否为诸如读写事件做好准备的组件。这样，一个
     * 单独的线程可以管理多个channel，从而管理多个网络连接。
     *
     * 与Selector一起使用时，Channel必须处于非阻塞模式下。
     * 这意味着不能将FileChannel与Selector一起使用，因为
     * FileChannel不能切换到非阻塞模式。而套接字通道都可以。
     *
     * @see SelectionKey
     * 当向Selector注册Channel时，register()方法会返回一个SelectionKey对象。
     * 这个对象包含了一些你感兴趣的属性：
     * 1.interest集合
     *  interest集合是你所选择的感兴趣的事件集合。可以通过SelectionKey读写interest集合
     *  int interestSet = selectionKey.interestOps();
     *  boolean isInterestedInAccept  = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT；
     *  boolean isInterestedInConnect = interestSet & SelectionKey.OP_CONNECT;
     *  boolean isInterestedInRead    = interestSet & SelectionKey.OP_READ;
     *  boolean isInterestedInWrite   = interestSet & SelectionKey.OP_WRITE;
     *  可以看到，用“位与”操作interest 集合和给定的SelectionKey常量，可以确定某个确定的事件是否在interest 集合中。
     * 2.ready集合
     *   ready 集合是通道已经准备就绪的操作的集合。在一次选择(Selection)之后，你会首先访问这个ready set.
     *   可以用像检测interest集合那样的方法，来检测channel中什么事件或操作已经就绪
     *   selectionKey.isAcceptable();
     *   selectionKey.isConnectable();
     *   selectionKey.isReadable();
     *   selectionKey.isWritable();
     * 3.Channel
     *   Channel  channel  = selectionKey.channel();
     * 4.Selector
     *   Selector selector = selectionKey.selector();
     * 5.附加的对象（可选）
     *   可以将一个对象或者更多信息附着到SelectionKey上，这样就能方便的识别某个给定的通道。
     *   例如，可以附加 与通道一起使用的Buffer，或是包含聚集数据的某个对象。使用方法如下:
     *   selectionKey.attach(theObject);
     *   Object attachedObj = selectionKey.attachment();
     *   还可以在用register()方法向Selector注册Channel的时候附加对象。如：
     *   SelectionKey key = channel.register(selector, SelectionKey.OP_READ, theObject);
     */
    public void selector() throws IOException {
        // 必须使用open()创建Selector
        // Selector selector = Selector.open();
        // 得到一个channel
        // ServerSocketChannel channel = ServerSocketChannel.open();

        // 向Selector注册通道
        // 注意register()方法的第二个参数。这是一个“interest集合”，
        // 意思是在通过Selector监听Channel时对什么事件感兴趣。可以监
        // 听四种不同类型的事件：
        // 1.Connect#SelectionKey.OP_CONNECT
        // 2.Accept#SelectionKey.OP_ACCEPT
        // 3.Read#SelectionKey.OP_READ
        // 4.Write#SelectionKey.OP_WRITE
        // 通道触发了一个事件意思是该事件已经就绪。所以，某个channel成
        // 功连接到另一个服务器称为“连接就绪”。一个server socket channel
        // 准备好接收新进入的连接称为“接收就绪”。一个有数据可读的通道可以说是“读就绪”。
        // 等待写数据的通道可以说是“写就绪。
        // 如果你对不止一种事件感兴趣，那么可以用“位或”操作符将常量连接起来，如下：
        // int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
        // channel.configureBlocking(false); // 设置为非阻塞模式
        // SelectionKey key = channel.register(selector,SelectionKey.OP_READ);

        // 通过Selector选择通道
        // selector.select();#阻塞到至少有一个通道在你注册的事件上就绪了。
        // selector.select(long timeout)和select()一样，除了最长会阻塞timeout毫秒(参数)。
        // selector.selectNow()不会阻塞，不管什么通道就绪都立刻返回（此方法执行非阻塞的选择操作。
        // 如果自从前一次选择操作后，没有通道变成可选择的，则此方法直接返回零。）
        // select()方法返回的int值表示有多少通道已经就绪.自上次调用select()方法后有多少通道变成就
        // 绪状态。如果调用select()方法，因为有一个通道变成就绪状态，返回了1，若再次调用select()方法，
        // 如果另一个通道就绪了，它会再次返回1。如果对第一个就绪的channel没有做任何操作，现在就有两个就
        // 绪的通道，但在每次select()方法调用之间，只有一个通道就绪了。

        // selectedKeys()
        // 一旦调用了select()方法，并且返回值表明有一个或更多个通道就绪了，然后可以通过调用
        // selector的selectedKeys()方法，访问“已选择键集（selected key set）”中的就绪
        // 通道。如下所示:
        // Set selectedKeys = selector.selectedKeys();

        // 当像Selector注册Channel时，Channel.register()方法会返回一个SelectionKey
        // 对象。这个对象代表了注册到该Selector的通道。可以通过Selector的selectedKeys()
        // 方法访问这些对象。

        // 每次迭代末尾的keyIterator.remove()调用,Selector不会自己从已选择键集中移除SelectionKey实例。
        // 必须在处理完通道时自己移除。下次该通道变成就绪时，Selector会再次将其放入已选择键集中。
        // SelectionKey.channel()方法返回的通道需要转型成你要处理的类型，如ServerSocketChannel或SocketChannel等。

        // wakeUp()某个线程调用select()方法后阻塞了，即使没有通道已经就绪，也有办法让其从select()方法返回。
        // 只要让其它线程在第一个线程调用select()方法的那个对象上调用Selector.wakeup()方法即可。阻塞在select()
        // 方法上的线程会立马返回。

        // close()
        // 用完Selector后调用其close()方法会关闭该Selector，且使注册到该Selector上的所有SelectionKey实例无效。
        // 通道本身并不会关闭。

        // 完整例子
        Selector selector = Selector.open();
        ServerSocketChannel channel = ServerSocketChannel.open();
        SocketChannel socketChannel = channel.accept();

        // 注册channel
        socketChannel.configureBlocking(false);// 设置为非阻塞模式
        SelectionKey key = socketChannel.register(selector, SelectionKey.OP_READ);

        while(true){
            int readyChannels = selector.select();
            if(readyChannels == 0) continue;

            Set selectedKeys = selector.selectedKeys();
            Iterator keyIterator = selectedKeys.iterator();
            while(keyIterator.hasNext()) {
                SelectionKey keys = (SelectionKey) keyIterator.next();
                if(keys.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.
                } else if (keys.isConnectable()) {
                    // a connection was established with a remote server.
                } else if (keys.isReadable()) {
                    // a channel is ready for reading
                } else if (keys.isWritable()) {
                    // a channel is ready for writing
                }
                keyIterator.remove();
            }
        }
    }

    /**
     * Java NIO中的FileChannel是一个连接到文件的通道。可以通过文件通道读写文件。
     * FileChannel无法设置为非阻塞模式，它总是运行在阻塞模式下。
     */
    public void fileChannel() throws IOException {
        // 打开一个FileChannel
        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        // FileChannel读取数据
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(buf);

        // 向FileChannel写数据
        String newData = "New String to write to file..." + System.currentTimeMillis();

        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.clear();
        buffer.put(newData.getBytes());

        buffer.flip();

        while(buffer.hasRemaining()) {
            inChannel.write(buffer);
        }

        // 关闭FileChannel
        inChannel.close();

        //
        inChannel.position();

        // FileChannel的size方法将返回该实例所关联文件的大小。
        long fileSize = inChannel.size();

        // FileChannel.truncate()方法截取一个文件。截取文件时，
        // 文件将中指定长度后面的部分将被删除
        inChannel.truncate(1024);

        // FileChannel.force()方法将通道里尚未写入磁盘的数据强制写到磁盘上。
        // 出于性能方面的考虑，操作系统会将数据缓存在内存中，所以无法保证写入到
        // FileChannel里的数据一定会即时写到磁盘上。要保证这一点，需要调用force()方法。
        // force()方法有一个boolean类型的参数，指明是否同时将文件元数据（权限信息等）写到磁盘上。
    }

    /**
     *
     * @throws IOException
     */
    public void socketChannel() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));

        // 从 SocketChannel 读取数据
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = socketChannel.read(buf);

        // 写入 SocketChannel
        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer bufs = ByteBuffer.allocate(48);
        bufs.clear();
        bufs.put(newData.getBytes());
        bufs.flip();
        while(buf.hasRemaining()) {
            socketChannel.write(bufs);
        }

        // 非阻塞模式
        // 可以设置 SocketChannel 为非阻塞模式（non-blocking mode）.设置之后，
        // 就可以在异步模式下调用connect(), read() 和write()了。
        // 如果SocketChannel在非阻塞模式下，此时调用connect()，该方法可能在连接建
        // 立之前就返回了。为了确定连接是否建立，可以调用finishConnect()的方法
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));
        while(! socketChannel.finishConnect() ){
            //wait, or do something else...
        }

        // write()
        // 非阻塞模式下，write()方法在尚未写出任何内容时可能就返回了。所以需要在循环中调用write()。

        // read()
        // 非阻塞模式下,read()方法在尚未读取到任何数据时可能就返回了。所以需要关注它的int返回值，
        // 它会告诉你读取了多少字节。

        // 关闭
        socketChannel.close();
    }

    /**
     * Java NIO中的 ServerSocketChannel 是一个可以监听新进来的TCP连接的通道,
     * 就像标准IO中的ServerSocket一样。ServerSocketChannel类在 java.nio.channels包中。
     */
    public void serverSocketChannel() throws IOException {
        // 打开
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 非阻塞模式
        // ServerSocketChannel可以设置成非阻塞模式。在非阻塞模式下，accept()
        // 方法会立刻返回，如果还没有新进来的连接,返回的将是null。因此，需要检查返
        // 回的SocketChannel是否是null.
        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.bind(new InetSocketAddress(9999));

        // 关闭
        serverSocketChannel.close();

        // 监听新进来的连接
        while(true){
            SocketChannel socketChannel =
                    serverSocketChannel.accept();
            //do something with socketChannel...

            if(socketChannel != null){
                //do something with socketChannel...
            }
        }
    }

    /**
     * Java NIO中的DatagramChannel是一个能收发UDP包的通道。
     * 因为UDP是无连接的网络协议，所以不能像其它通道那样读取和写入。
     * 它发送和接收的是数据包。
     */
    public void datagramChannel() throws IOException {
        // 打开
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(9999));

        // 接受数据
        ByteBuffer buf0 = ByteBuffer.allocate(48);
        buf0.clear();
        channel.receive(buf0);

        // 发送数据
        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();
        int bytesSent = channel.send(buf, new InetSocketAddress("jenkov.com", 80));

        // 连接到特定地址（客户端）
        // 当连接后，也可以使用read()和write()方法，就像在用传统的通道一样。只是在数据传送方面没有任何保证。
        channel.connect(new InetSocketAddress("jenkov.com", 80));
        int bytesRead = channel.read(buf);
        int bytesWritten = channel.write(buf);
    }

    /**
     * Java NIO 管道是2个线程之间的单向数据连接。Pipe有一个source通道和一个sink通道。
     * 数据会被写到sink通道，从source通道读取。
     */
    public void pipe() throws IOException {
        // 创建管道
        Pipe pipe = Pipe.open();

        // 向管道写数据
        // 通过调用SinkChannel的write()方法，将数据写入SinkChannel
        Pipe.SinkChannel sinkChannel = pipe.sink();
        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());

        buf.flip();

        while(buf.hasRemaining()) {
            sinkChannel.write(buf);
        }

        // 从管道读取数据
        // 从读取管道的数据，需要访问source通道
        Pipe.SourceChannel sourceChannel = pipe.source();
        ByteBuffer buf0 = ByteBuffer.allocate(48);
        int bytesRead = sourceChannel.read(buf0);
    }

    /**
     * Java NIO和IO的主要区别
     * IO                NIO
     * 面向流            面向缓冲
     * 阻塞IO            非阻塞IO
     * 无                选择器
     *
     *
     */
    public void nioAndIo() {

    }

    /**
     * Path接口是java NIO2的一部分。首次在java 7中引入。Path接口在java.nio.file包下，
     * 所以全称是java.nio.file.Path。 java中的Path表示文件系统的路径。可以指向文件或文
     * 件夹。也有相对路径和绝对路径之分。绝对路径表示从文件系统的根路径到文件或是文件夹的路径。
     * 相对路径表示从特定路径下访问指定文件或文件夹的路径。相对路径的概念可能有点迷糊。不用担
     * 心，我将在本文的后面详细介绍相关细节。
     *
     * 不要将文件系统的path和操作系统的环境变量path搞混淆。java.nio.file.Path接口和操作系统
     * 的path环境变量没有任何关系。
     *
     * 在很多方面，java.nio.file.Path接口和java.io.File有相似性，但也有一些细微的差别。在很
     * 多情况下，可以用Path来代替File类。
     *
     *
     */
    public void path() {
        // 创建Path实例
        Path path0 = Paths.get("c:\\data\\myfile.txt");
        Path path1 = Paths.get("/home/jakobjenkov/myfile.txt");

        System.out.println(path1.toAbsolutePath()); // 获取文件的地址

        String originalPath =
                "d:\\data\\projects\\a-project\\..\\another-project";


        // Path 的normalize()方法可以标准化路径。标准化的含义是路径中的.和..都被去掉，
        // 指向真正的路径目录地址。
        Path path2 = Paths.get(originalPath);
        System.out.println("path2 = " + path2);

        Path path3 = path2.normalize();
        System.out.println("path3 = " + path3);
    }

    /**
     * 在Java 7，AsynchronousFileChannel 被添加到了Java NIO中。
     * 使用AsynchronousFileChannel可以实现异步地读取和写入文件数据。
     */
    public void asynchronousFileChannel() throws IOException {
        // 创建
        // 第一个参数是一个 PATH 的对像实例，它指向了那个与 AsynchronousFileChannel
        // 相关联的文件。
        // 第二个参数是一个或多个操作选项，它决定了 AsynchronousFileChannel 将对目标
        // 文件做何种操作。示例代码中我们使用了 StandardOpenOption.READ ，它表明我们
        // 将要对目标文件进行读操作。
        Path path = Paths.get("data/test.xml");
        AsynchronousFileChannel fileChannel =
                AsynchronousFileChannel.open(path, StandardOpenOption.READ);


        // 读取
        // AsynchronousFileChannel提供了两种读取数据的方式，都是调用它本身的read()方法

        // 一、使用Futrue读取数据
        ByteBuffer buffer = ByteBuffer.allocate(48);
        long position = 0;

        Future<Integer> operation = fileChannel.read(buffer, position);

        while(!operation.isDone());

        buffer.flip();
        byte[] data = new byte[buffer.limit()];
        buffer.get(data);
        System.out.println(new String(data));
        buffer.clear();

        // 二、使用CompletionHandler读取数据
        // 一旦读取操作完成，CompletionHandler的 complete() 方法将会被调用。
        // 它的第一个参数是个 Integer类型，表示读取的字节数。第二个参数 attachment
        // 是 ByteBuffer 类型的，用来存储读取的数据。它其实就是由 read()方法的第三
        // 个参数。当前示例中，我们选用 ByteBuffer 来存储数据，其实我们也可以选用其他
        // 的类型。读取失败的时候，CompletionHandler的 failed()方法会被调用。
        fileChannel.read(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("result = " + result);

                attachment.flip();
                byte[] data = new byte[attachment.limit()];
                attachment.get(data);
                System.out.println(new String(data));
                attachment.clear();
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {

            }
        });

        // 写入数据

        // 一、使用Future读取数据
        Path path0 = Paths.get("data/test-write.txt");
        AsynchronousFileChannel fileChannel0 =
                AsynchronousFileChannel.open(path0, StandardOpenOption.WRITE);

        ByteBuffer buffer0 = ByteBuffer.allocate(1024);
        long position0 = 0;

        buffer0.put("test data".getBytes());
        buffer0.flip();

        Future<Integer> operation0 = fileChannel0.write(buffer0, position0);
        buffer0.clear();

        while(!operation0.isDone());

        System.out.println("Write done");


        // 二、使用CompletionHandler写入数据
        // 当写入程序完成时，CompletionHandler的completed()方法将会被调用，
        // 相反的如果写入失败则会调用failed()方法。
        // 要留意CompletionHandler的方法的参数attachemnt是怎么使用的。
        Path path3 = Paths.get("data/test-write.txt");
        if(!Files.exists(path3)){
            Files.createFile(path3);
        }
        AsynchronousFileChannel fileChannel3 =
                AsynchronousFileChannel.open(path3, StandardOpenOption.WRITE);

        ByteBuffer buffer3 = ByteBuffer.allocate(1024);
        long position3 = 0;

        buffer3.put("test data".getBytes());
        buffer3.flip();

        fileChannel3.write(buffer3, position3, buffer3, new CompletionHandler<Integer, ByteBuffer>() {

            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("bytes written: " + result);
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println("Write failed");
                exc.printStackTrace();
            }
        });



    }
}










