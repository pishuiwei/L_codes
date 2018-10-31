package factoryMethod;

public class HaierTVFactory implements TVFactory{

	@Override
	public HaierTV produceTV() {
		System.out.println("生产海尔电视.....");
		return new HaierTV();
	}
	
	
}
