import java.io.IOException;
import java.io.OutputStream;

public class IOStream {

    public static void main(String[] args) throws IOException {

        byte b = 127;

        System.out.println();



        IOStream.generateCharacters1(System.out);

    }


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




}
