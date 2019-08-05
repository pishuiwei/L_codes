import java.io.*;

public class CSDNUtil {

    public static final String NEW_LINE = System.getProperty("line.separator");

    /**
     * 获取文件流
     * @return
     */
    public static BufferedReader getSourceFile() {
        File file = new File("D:\\pw\\project\\L_codes\\L_Java\\CSDN\\" + "sources");
        System.out.println(file.getAbsoluteFile());
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            return br;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


    public  static void setTarget(String source) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("D:\\pw\\project\\L_codes\\L_Java\\CSDN\\target");
            fw.write(source);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null)
                fw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fw != null)
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
