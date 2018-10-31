package state;

/**
 * 具体状态
 * ()
 * @author PW 2018/04/07
 *
 */
public class PrimaryState extends AbsteactState{

	public PrimaryState(AbsteactState state) {
		this.acc = state.acc;
		this.point = state.point;
		this.stateName = "新手";
	}
	
	public PrimaryState(ForumAccount acc) {
		this.acc = acc;
		this.point = 0;
		this.stateName = "新手";
	}
	
	@Override
	public void downloadFiel(int score) {
		System.out.println("对不起，" + acc.getName() + ",您没有下载文件的权限!");
	}
	
	@Override
	public void checkState(int score) {
		if (point >= 1000) {
			acc.setState(new HighState(this));
		} else if (point >= 100) {
			acc.setState(new MiddleState(this));
		}
		
	}

}
