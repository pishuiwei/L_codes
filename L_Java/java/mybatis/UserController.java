package mybatis;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class UserController {

	public static void main(String[] args) {
		SqlSession session = SqlSessionTools.getSession();
		
		UserMapper userMapper = session.getMapper(UserMapper.class);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("age", 20);
		
		
		User user = userMapper.findById("李四", map);
		
		
		System.out.println(user.getName());

	}

}
