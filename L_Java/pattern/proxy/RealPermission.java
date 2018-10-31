package proxy;

/**
 * 真实主题角色（真实权限类）
 * @author PW 2018/04/01
 *
 */
public class RealPermission implements AbstractPermission{

	@Override
	public void modifyUserInfo() {
		System.err.println("修改用户信息!");
	}

	@Override
	public void viewNote() {
	}

	@Override
	public void publicshNote() {
		System.err.println("发布新帖!");
	}

	@Override
	public void modifyNote() {
		System.err.println("修改发布内容");
	}

	@Override
	public void setLevel(int level) {
		
	}

}
