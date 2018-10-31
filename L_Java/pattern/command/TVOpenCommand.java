package command;

/**
 * 具体命令类
 * @author PW 2018/04/06
 *
 */
public class TVOpenCommand implements AbstractCommand{

	private Television tv;

	public TVOpenCommand() {
		tv = new Television();
	}
	
	@Override
	public void execute() {
		tv.open();
	}

}
