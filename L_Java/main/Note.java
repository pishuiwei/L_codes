import java.io.*;

public class Note {

    public static void main(String[] args) {
        form();
    }

    public  static void form() {
        String path = Note.class.getResource("/").getPath();
        File file = new File(path + "s");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            int i = 1;
            StringBuffer sb = new StringBuffer();
            sb.append("|方法|描述|\r\n");
            sb.append("|:----|:----|\r\n");
            while ((line = br.readLine()) != null) {
                if (i%2 == 1) {
                    sb.append("|").append(line);
                }
                if (i%2 == 0) {
                    sb.append("|").append(line).append("|").append("\r\n");
                }
                i++;
            }

            FileWriter fw = new FileWriter("C:\\Pw\\project\\L_codes\\L_Java\\main\\t");
            fw.write(sb.toString());
            fw.flush();
            fw.close();
//            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
