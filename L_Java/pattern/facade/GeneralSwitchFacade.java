package facade;

/**
 * 外观类
 * @author PW 2018/04/06
 *
 */
public class GeneralSwitchFacade {
	
	private Light light[] = new Light[4];
	
	private Fan fan;
	
	public GeneralSwitchFacade() {
		light[0] = new Light("左前");
		light[1] = new Light("右前");
		light[2] = new Light("左后");
		light[3] = new Light("右后");
		fan = new Fan();
	}
	
	public void on() {
		for (Light lights : light) {
			lights.on();
		}
		fan.on();
	}
	
	public void off() {
		for (Light lights : light) {
			lights.off();
		}	
		fan.off();
	}
	
}
