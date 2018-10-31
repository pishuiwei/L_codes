package prototypeManager;

public class Blue implements MyColor{

	public Object clone() {
		Blue blue = null;
		
		try {
			blue = (Blue) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("克隆失败");
		}
		
		return blue;
	}
	
	public void display() {
		System.out.println("This is blue!");
	}

}
