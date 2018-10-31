package chain;

/**
 * 抽象处理者
 * (领导类)
 * @author PW 2018/04/06
 *
 */
public abstract class Leader {
	
	protected String name;
	
	protected Leader successor;

	public Leader(String name) { 
		this.name = name;
	}

	public void setSuccessor(Leader successor) {
		this.successor = successor;
	}

	public abstract void handleRequest(LeaveRequest request);
	
}
