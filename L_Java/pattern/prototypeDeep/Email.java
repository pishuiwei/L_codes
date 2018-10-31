package prototypeDeep;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import prototype.Attachment;

/**
 * 深克隆
 * @author PW 2018/04/01
 *
 */
public class Email implements Serializable{
	
	public String name;

	private static final long serialVersionUID = 1L;

	private Attachment attachment = null;
	
	public Email() {
		this.attachment = new Attachment();
	}
	
	public Object deepClone() throws IOException, ClassNotFoundException {
		// 将对象写入流中
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bao);
		oos.writeObject(this);
		
		// 将对象从流中取出
		ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}
	
	public Attachment getAttachment() {
		return this.attachment;
	}
	
	public void display() {
		System.out.println("查看邮件");
	}
	
}
