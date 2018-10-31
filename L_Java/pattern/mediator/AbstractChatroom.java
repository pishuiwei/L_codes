package mediator;


/**
 * 抽象聊天室（抽象中介者类）
 * @author PW 2018/04/02
 *
 */
public abstract class AbstractChatroom {
	
	public abstract void register(Member member);
	
	public abstract void sendText(String from, String to, String message);
	
	public abstract void sendImage(String from, String to, String image);

}
