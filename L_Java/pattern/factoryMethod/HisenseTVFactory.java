package factoryMethod;

public class HisenseTVFactory implements TVFactory{

	@Override
	public TV produceTV() {
		System.out.println("海信电视生产中....");
		return new HisenseTV();
	}


}
