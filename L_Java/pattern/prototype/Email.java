package prototype;

/**
 * 浅克隆
 * 邮件类（具体原型类） 
 * @author PW 2018/04/01
 * 
 */
public class Email implements Cloneable{
	
	private Attachment attachment = null;
	
	public Email() {
		this.attachment = new Attachment();
	}
	
	public Object clone() {
		Email clone = null;
		
		try {
			clone = (Email)super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Clone failure!");
		}
		return clone;
	}
	
	public Attachment getAttachment() {
		return this.attachment;
	}
	
	public void display() {
		System.out.println("查看邮件");
	}
	
}
