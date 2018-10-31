package mybatis;

import java.util.Map;

public interface UserMapper {
	
	public User findById(String name, Map<String, Integer> map);

}
