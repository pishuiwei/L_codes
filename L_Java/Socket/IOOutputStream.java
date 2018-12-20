import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author PP 2018-12-19
 *
 * 演示输出流的使用
 *
 * @see     java.io.BufferedOutputStream
 * @see     java.io.ByteArrayOutputStream
 * @see     java.io.DataOutputStream
 * @see     java.io.FilterOutputStream
 * @see     java.io.OutputStream#write(int)
 */
public class IOOutputStream {

    public static void generateCharacters0(OutputStream out) throws IOException {
        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacters= 94;
        int numberOfCharactersPerLine = 72;

        int start = firstPrintableCharacter;
        while(true) {
            for (int i = start; i < start + numberOfCharactersPerLine; i++) {
                out.write((
                        (i - firstPrintableCharacter) % numberOfPrintableCharacters)
                        + firstPrintableCharacter);
            }
            out.write('\r');    // 回车
            out.write('\n');    // 换行
            start = ((start + 1) - firstPrintableCharacter) % numberOfCharactersPerLine + firstPrintableCharacter;
        }
    }

    public static void generateCharacters1(OutputStream out) throws IOException {
        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacters= 94;
        int numberOfCharactersPerLine = 72;
        int start = firstPrintableCharacter;

        // +2对应回车和换行
        byte[] line = new byte[numberOfCharactersPerLine + 2];

        while(true) {
            for (int i = start; i < start + numberOfCharactersPerLine; i++) {
                line[i - start] = (byte)((i - firstPrintableCharacter)
                    % numberOfPrintableCharacters + firstPrintableCharacter);
            }
            line[72] = (byte)'\r';
            line[73] = (byte)'\n';
            out.write(line);

            start = ((start + 1) - firstPrintableCharacter) % numberOfCharactersPerLine + firstPrintableCharacter;
        }
    }

    /**
     *  Java7新引进的"带资源的try"。
     *
     *  Java会对try块参数表中声明的所有AutoCloseable对象自动调用close。
     *
     *  可以减少对finally块的使用
     *
     */
    public void tryWithResources() {
        try(OutputStream out = new FileOutputStream("")) {

        } catch (IOException ex) {

        }
    }




}















