package json;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * 使用gson-2.3.1.jar
 * @author Administrator
 *
 */
public class JSONGson {
	
	public static void main(String[] args) {
		setJSON();//
//		getJSON();//
	}
	
	public static void getJSON(){
		JsonParser parser = new JsonParser();//
		try {
			JsonObject object = (JsonObject) parser.parse(new FileReader("D:/test.json")) ;
			System.out.println("cat=" + object.get("cat").getAsString());//
			System.out.println("pop=" + object.get("pop").getAsBoolean());//
			
			JsonArray employees = object.get("employees").getAsJsonArray();
			for(int i = 0;i<employees.size();i++){
				System.out.println("----------------");
				JsonObject subObject = employees.get(i).getAsJsonObject();
				System.out.println("name="+subObject.get("name").getAsString());
				System.out.println("pass="+subObject.get("pass").getAsString());
			}
			
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace(); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void setJSON(){
		JsonObject object = new JsonObject(); 
		
		object.addProperty("cat", "maomi");
		
		JsonArray array = new JsonArray();
		
		JsonObject lan1 = new JsonObject(); 
		lan1.addProperty("name", "pp1");
		lan1.addProperty("pass", "123");
		array.add(lan1);
		
		JsonObject lan2 = new JsonObject(); 
		lan2.addProperty("name", "pp2");
		lan2.addProperty("pass", "456");
		array.add(lan2);
		
		object.add("employees", array);
		
		object.addProperty("pop", true);
		
		System.out.println(object.toString());
	}

}
