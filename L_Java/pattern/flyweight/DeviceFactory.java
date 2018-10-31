package flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * 只有内部状态，没有外部状态
 * @author PW 2018/04/06
 *
 */
public class DeviceFactory {
  
	private List<NetworkDevice> devices = new ArrayList<>(); // 享元池
	
	private int totalTerminal = 0;
	
	public DeviceFactory() {
		NetworkDevice nd1 = new Switch("Cisc0-WS-C2950-24");
		devices.add(nd1);
		NetworkDevice nd2 = new Hub("TP-LINK-HF8M");
		devices.add(nd2);
	}
	
	public NetworkDevice getNetworkDevice(String type) {
		if (type.equalsIgnoreCase("cisco")) {
			totalTerminal++;
			return devices.get(0);
		} else if (type.equalsIgnoreCase("tp")) {
			totalTerminal++;
			return devices.get(1);
		} else {
			return null;
		}
	}
	
	public int getTotalDevice() {
		return devices.size();
	}

	public int getTotalTerminal() {
		return totalTerminal;
	}
	
}

