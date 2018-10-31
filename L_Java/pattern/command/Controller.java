package command;

/**
 * 调用者类
 * （遥控器类）
 * @author PW 2018/04/06
 *
 */
public class Controller {

	private AbstractCommand openCommand, closeCommand, changeCommand;

	public Controller(AbstractCommand openCommand, AbstractCommand closeCommand, AbstractCommand changeCommand) {
		this.openCommand = openCommand;
		this.closeCommand = closeCommand;
		this.changeCommand = changeCommand;
	}
	
	public void open() {
		openCommand.execute();
	}
	
	public void change() {
		closeCommand.execute();
	}
	
	public void close() {
		changeCommand.execute();
	}
	
	
	
	
}
