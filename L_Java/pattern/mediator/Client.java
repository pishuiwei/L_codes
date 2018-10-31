package mediator;

public class Client {

	public static void main(String[] args) {
		AbstractChatroom happychat = new ChatGroup();
		
		Member member1, member2, member3, member4, member5;
		member1 = new DiamondMember("张三");
		member2 = new DiamondMember("李四");
		member3 = new CommonMember("王五");
		member4 = new CommonMember("小芳");
		member5 = new CommonMember("小红");
		
		happychat.register(member1);
		happychat.register(member2);
		happychat.register(member3);
		happychat.register(member4);
		happychat.register(member5);
		
		member1.sendText("李四", "李四，你好！");
		
	}
}
