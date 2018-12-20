import java.io.*;

/**
 * @author pp 2018-12-20
 *
 * 演示阅读器的使用
 *
 * @see java.io.Reader
 * @see java.io.BufferedReader
 * @see   java.io.LineNumberReader
 * @see java.io.CharArrayReader
 * @see java.io.InputStreamReader
 * @see   java.io.FileReader
 * @see java.io.FilterReader
 * @see   java.io.PushbackReader
 * @see java.io.PipedReader
 * @see java.io.StringReader
 *
 */
public class IOReader {

    /**
     * 演示基本方法writer的使用
     */
    public void writer() throws IOException {
        Reader r = new InputStreamReader(System.in);
        r.read();
    }

    /**
     * 演示BufferedReader的使用
     */
    public void buffered() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
    }

}
