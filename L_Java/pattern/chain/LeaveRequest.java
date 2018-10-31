package chain;

/**
 * 请求类
 * (请假条类)
 * @author PW 2018/04/06
 *
 */
public class LeaveRequest {
	
	private String leaveName;
	
	private int leaveDays;

	public LeaveRequest(String leaveName, int leaveDays) {
		this.leaveName = leaveName;
		this.leaveDays = leaveDays;
	}

	public String getLeaveName() {
		return leaveName;
	}

	public void setLeaveName(String leaveName) {
		this.leaveName = leaveName;
	}

	public int getLeaveDays() {
		return leaveDays;
	}

	public void setLeaveDays(int leaveDays) {
		this.leaveDays = leaveDays;
	}
	
}
