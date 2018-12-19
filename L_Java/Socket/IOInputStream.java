import java.io.*;

/**
 * @author PP 2018-12-19
 *
 * 这个类演示了Java输入流的使用
 *
 *  available()方法给出了不阻塞的情况下有多少字节可以读取（当前建议读取的字节）。
 *  sipe() 方法跳过数据不进行读取。
 * @see InputStream
 */
public class IOInputStream {

    public static void main(String[] args) throws IOException {
        IOInputStream demo = new IOInputStream();
//        demo.read();
//        demo.readByte0();
//        demo.readByte1();
        DataOutputStream dataOutputStream = new DataOutputStream(System.out);
        dataOutputStream.writeUTF("我");
    }

    /**
     *  演示InputStream的read()方法
     *  读取文件中的内容，并且把文件中的内容输出到控制台
     *
     */
    public void read() throws IOException {
        InputStream in = new FileInputStream("./L_Java/Socket/text/2、流");
        OutputStream out= System.out;

        int i ;
        while ((i = in.read()) != -1) {
            out.write(i);
        }
    }

    /**
     * 演示reed(byte[] input)方法，此方法会尝试填充指定的数组input
     */
    public void readByte0() throws IOException {
        InputStream in = new FileInputStream("./L_Java/Socket/text/2、流");
        OutputStream out= System.out;

        byte[] bytes = new byte[1024];

        while ((in.read(bytes)) != -1) {
            out.write(bytes);
        }
    }

    /**
     * 演示reed(byte[] input,int offset, int length),此方法会尝试填充指定的input中从offset开始，
     * 连续length字节
     *
     */
    public void readByte1() throws IOException {
        InputStream in = new FileInputStream("./L_Java/Socket/text/2、流");
        OutputStream out= System.out;

        byte[] bytes = new byte[1024];

        while ((in.read(bytes,0,bytes.length)) != -1) {
            out.write(bytes);
        }
    }

}
