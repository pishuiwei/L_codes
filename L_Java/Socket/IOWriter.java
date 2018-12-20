import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * @author pp 2018-12-20
 *
 *  演示书写器的使用
 *
 * @see     java.io.Writer
 * @see     java.io.BufferedWriter
 * @see     java.io.CharArrayWriter
 * @see     java.io.FilterWriter
 * @see     java.io.OutputStreamWriter
 * @see     java.io.FileWriter
 * @see     java.io.PipedWriter
 * @see     java.io.PrintWriter
 * @see     java.io.StringWriter
 */
public class IOWriter {

    /**
     * 演示基本方法writer的使用，注意必须使用flush()刷新缓存
     */
    public void writer() throws IOException {
        Writer w = new OutputStreamWriter(System.out);
        w.write("我");
        w.flush();
    }

    /**
     * 演示BufferedWriter的使用
     */
    public void buffered() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("缓冲字符流");
        bw.flush();
    }

}






