package state;

public class Demo {

	public static void main(String[] args) {
		ForumAccount account = new ForumAccount("张三");
		account.writeNote(20);
		System.out.println("------------------------------------");
		account.downloadFile(20);
		System.out.println("------------------------------------");
		account.replyNote(100);
		System.out.println("------------------------------------");
		account.writeNote(40);
		System.out.println("------------------------------------");
		account.downloadFile(80);
		System.out.println("------------------------------------");
		account.downloadFile(150);
		System.out.println("------------------------------------");
		account.writeNote(100);
		System.out.println("------------------------------------");
		account.downloadFile(80);
		System.out.println("------------------------------------");
		
	}
	
}
