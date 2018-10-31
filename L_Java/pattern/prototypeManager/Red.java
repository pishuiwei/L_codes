package prototypeManager;

public class Red implements MyColor{

	public Object clone() {
		Red red = null;
		
		try {
			red = (Red) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("克隆失败");
		}
		
		return red;
	}
	
	public void display() {
		System.out.println("This is red!");
	}

}
