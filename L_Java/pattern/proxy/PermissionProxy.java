package proxy;

/**
 * 代理主题角色（权限代理类）
 * @author PW 2018/04/01
 *
 */
public class PermissionProxy implements AbstractPermission{
	
	private RealPermission permossion = new RealPermission();
	private int level = 0;

	@Override
	public void modifyUserInfo() {
		if (0 == level) {
			System.out.println("对不起，你没有该权限!");
		} else if (1 == level) {
			permossion.modifyUserInfo();
		}
	}

	@Override
	public void viewNote() {
		System.out.println("查看帖子");
	}

	@Override
	public void publicshNote() {
		if (0 == level) {
			System.out.println("对不起，你没有该权限!");
		} else if (1 == level) {
			permossion.publicshNote();
		}
	}

	@Override
	public void modifyNote() {
		if (0 == level) {
			System.out.println("对不起，你没有该权限!");
		} else if (1 == level) {
			permossion.modifyNote();
		}
	}

	@Override
	public void setLevel(int level) {
		this.level = level;
	}

}
