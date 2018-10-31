package state;

/**
 * 环境类
 * @author PW 2018/04/07
 *
 */
public class ForumAccount {

	private AbsteactState state;
	
	private String name;

	public ForumAccount(String name) {
		this.state = new PrimaryState(this);
		this.name = name;
		System.out.println(name  + "注册成功!");
		System.out.println("----------------------");
	}

	public AbsteactState getState() {
		return state;
	}

	public void setState(AbsteactState state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void downloadFile(int scor) {
		state.downloadFiel(scor);
	}
	
	public void writeNote(int score) {
		state.writeNote(score);
	}
	
	public void replyNote(int score) {
		state.replyNote(score);
	}
	
	
}
