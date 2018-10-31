package abstractFactory;

/**
 * 电器工厂类 
 * @author PW 2018/03/30
 *
 */
public interface EFactory {
	
	public Television produceTelevision();
	
	public AirConditioner produceAirConditioner();
	
}
