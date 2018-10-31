package command;

public class TvChangeCommand implements AbstractCommand{
	
	private Television tv;

	public TvChangeCommand() {
		tv = new Television();
	}
	
	@Override
	public void execute() {
		tv.changeChannel();
	}

}
