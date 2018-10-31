package chain;

/**
 * 具体处理者类
 * (总经理类)
 * @author PW 2018/04/06
 *
 */
public class GeneralManager extends Leader{

	public GeneralManager(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		if (request.getLeaveDays() < 3) {
			System.out.println("主任" + name + "审批员工" + request.getLeaveName() + "的请假条，请假天数为" + request.getLeaveDays() + "天");
		} else {
			System.out.println("莫非" + request.getLeaveName() + "想辞职，居然请假" + request.getLeaveDays() +"天");
		}
	}

}
