package abstractFactory;

public class TCLAirConditioner implements AirConditioner{

	@Override
	public void changeTemperature() {
		System.out.println("TCL 空调改变温度中....");
	}

}
