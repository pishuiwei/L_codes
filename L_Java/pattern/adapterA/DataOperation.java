package adapterA;

/** 目标抽象类  */
public abstract class DataOperation {

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public abstract String doEncrypt(int key, String ps);
	
}
