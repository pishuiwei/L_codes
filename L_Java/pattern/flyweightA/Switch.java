package flyweightA;

/**
 * 具体享元类
 * 交换机类
 * @author PW 2018/04/06
 *
 */
public class Switch implements NetworkDevice{

	private String type;
	
	public Switch(String type) {
		this.type = type;
	}
	
	@Override
	public String getType() {
		return type;
	}

	@Override
	public void use(Port port) {
		System.out.println("Linked by switch, type is " + type + ",port is " + port.getPort());
	}

}
