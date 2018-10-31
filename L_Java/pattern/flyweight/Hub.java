package flyweight;

/**
 * 具体享元类
 * 集线器类
 * @author PW 2018/04/06
 *
 */
public class Hub implements NetworkDevice{

	private String type;
	
	public Hub(String type) {
		this.type = type;
	}
	
	@Override
	public String getType() {
		return type;
	}

	@Override
	public void use() {
		System.out.println("Linked by hub, type is " + type);
	}

}
