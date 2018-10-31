package json;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import annotation.Junit;
import annotation.Test;

/**
 * 
 * @author PP
 * 2017-09-03 18:50
 *
 */
public class GsonDem {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Junit.run(GsonDem.class);
	}
	
	/**
	 * 创建json对象，并且输出到文件
	 * @throws FileNotFoundException 
	 */
	@Test
	public void createJson() throws FileNotFoundException {
		JsonObject json = new JsonObject();
		json.addProperty("cat", "maomi");
		
		JsonArray array = new JsonArray();
		
		JsonObject lan1 = new JsonObject();
		lan1.addProperty("name", "format");
		lan1.addProperty("pass", "language");
		array.add(lan1);
		
		JsonObject lan2 = new JsonObject();
		lan2.addProperty("name", "country");
		lan2.addProperty("pass", "header");
		array.add(lan2);
		
		json.add("employess", array);	
		json.addProperty("column", "thread");
		
		FileOutputStream fos = new FileOutputStream("F://item//learngit//JavaWeb//Learn//Java//src//main//java//com//pp//learn//json//pp.json");
		PrintWriter pWriter = new PrintWriter(fos);
		pWriter.write(json.toString());
		pWriter.close();
	}
	
	public void getJson() {
		
	}
}




