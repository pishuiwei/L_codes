package json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * json.lib.2.4.jsk15.jar
 * @author Administrator
 *
 */
public class JSONLibJDK15 {
	
	public static void main(String[] args) {
		getJson();
	}
	
	public static JSONObject  setJson(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("user", "pp");
		
		JSONArray jsonArray = new JSONArray();
		
		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("name", "1");
		jsonObject1.put("pass", "1");
		jsonArray.add(jsonObject1);
		
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("name", "2");
		jsonObject2.put("pass", "2");
		jsonArray.add(jsonObject2);
		
		jsonObject.put("cat", jsonArray);
		
		jsonObject.put("dog", "xxx");
		
		return jsonObject;
		
	}
	
	public static void getJson(){
		JSONObject jsonObject = setJson();
		Object object = jsonObject.get("user");
		
		System.out.println(object);
		
	}


}
