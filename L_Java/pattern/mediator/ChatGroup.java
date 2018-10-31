package mediator;

import java.util.Hashtable;

public class ChatGroup extends AbstractChatroom {

	private Hashtable<String, Member> members = new Hashtable<>();
	
	@Override
	public void register(Member member) {
		if (!members.contains(member)) {
			members.put(member.getName(), member);
			member.setChatroom(this);
		}
	}

	@Override
	public void sendText(String from, String to, String message) {
		Member member = members.get(to);
		String newMessage = message.replace("日", "*");
		member.receiveText(from, newMessage);
	}

	@Override
	public void sendImage(String from, String to, String image) {
		Member member = members.get(to);
		if (image.length() > 5) {
			System.out.println("图片太大，发送失败！");
		}else {
			member.receiveImage(from, image);
		}
	}

}
