package prototypeDeep;

import java.io.IOException;

public class Client {
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Email email,copyEmail;
		email = new Email();
		
		copyEmail = (Email) email.deepClone();
		
		System.out.println(email == copyEmail);
		
		System.out.println(email.getAttachment() == copyEmail.getAttachment());
	}
	
	
}
