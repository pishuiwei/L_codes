import java.io.BufferedReader;
import java.io.IOException;

public class CSDNCreateTable {

    public static void three_col() throws IOException {
        BufferedReader br = CSDNUtil.getSourceFile();
        String line;
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while ((line = br.readLine()) !=null) {
            sb.append("|");
            sb.append(line.replace("\t","|") + "|" + CSDNUtil.NEW_LINE);
            if (i==1) {
                sb.append("|:--|:--|:--|"  + CSDNUtil.NEW_LINE);
            }
            i++;
        }
        CSDNUtil.setTarget(sb.toString());
    }

}
