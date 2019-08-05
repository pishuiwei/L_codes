import java.io.*;

public class Code {

    private static final String NEW_LINE = System.getProperty("line.separator");

    public static void main(String[] args) throws IOException {
//        setCode("json");

        CSDNCreateTable.three_col();
    }

    public static void setCode(String type) throws IOException {
        File file = new File("D:\\pw\\project\\L_codes\\L_Java\\CSDN\\" + "sources");
        System.out.println(file.getAbsoluteFile());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        StringBuilder sb = new StringBuilder();
        sb.append("```" + type + NEW_LINE);

        while ((line = br.readLine()) != null) {
            if (line.equalsIgnoreCase("==")) {
                sb.append("```" + NEW_LINE + NEW_LINE);
                sb.append("```" + type + NEW_LINE);
                continue;
            }
            sb.append(line + NEW_LINE);
        }
        sb.append("```");

        FileWriter fw = new FileWriter("D:\\pw\\project\\L_codes\\L_Java\\CSDN\\target");
        fw.write(sb.toString());
        fw.flush();
        fw.close();

        System.out.println(sb.toString());
    }

}
