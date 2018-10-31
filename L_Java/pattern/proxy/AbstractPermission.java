package proxy;

/**
 * 抽象主题角色（抽象权限类）
 * @author PW 2018/04/01 
 *  
 */
public interface AbstractPermission {

	public void modifyUserInfo();
	
	public void viewNote();
	
	public void publicshNote();
	
	public void modifyNote();
	
	public void setLevel(int level);
}
