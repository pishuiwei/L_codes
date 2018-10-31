package prototype;

import java.io.Serializable;

public class Attachment implements Serializable{
	private static final long serialVersionUID = 1L;

	public void download() {
		System.out.println("下载附件...");
	}
}
