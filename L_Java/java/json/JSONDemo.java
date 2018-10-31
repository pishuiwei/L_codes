package json;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import net.sf.json.JSONObject;

public class JSONDemo {
	
	public static void main(String[] args) throws FileNotFoundException {
		caeateJson("json.json");
	}
	
	/**
	 * 创建json并写入文件
	 * @throws FileNotFoundException
	 */
	 public static void caeateJson(String fileName) throws FileNotFoundException {
		 FileOutputStream fos = new FileOutputStream(fileName);
		 PrintWriter pw = new PrintWriter(fos);
		 
		 JSONObject jsonObject = new JSONObject();
		 jsonObject.put("name", "pp");
		 
		 pw.write(jsonObject.toString());
		 pw.close();
		 
	 }

}
