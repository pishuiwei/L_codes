package singleFactory;

public class TVFactory{

	public TV produceTV(String tvName) {
		try {
			Class<?> c = Class.forName(tvName);
			Object obj = c.newInstance();
			return (TV)obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
