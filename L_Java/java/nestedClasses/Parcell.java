package nestedClasses;

/**
 * 创建内部类
 * 2017-08-24
 * @author pp
 *
 */
public class Parcell {
	public String string = "s";
	
	public class Contents {
		private int i = 11;
		public int value() { return i; }
	}

	public class Destination {
		private String label;
		Destination(String whereTo) { label = whereTo; Parcell.this.string="ss";}
		public String readLabel() { return label; }
	}
	
	public Destination to(String s) {
		return new Destination(s);
	}

	public void ship(String dest) {
		Destination d = new Destination(dest);
		System.out.println(d.readLabel());
	}

	public static void main(String[] args) {
		Parcell p = new Parcell();
		p.ship("Tasmania");
		
		Parcell.Test test = new Parcell().new Test();
		test.s();
		//Destination sDestination = p.to("s");
		//Parcell.Destination sDestination = p.to("s");
	}
	
	public class Test {
		public void s() {
			
		}
	}
}
