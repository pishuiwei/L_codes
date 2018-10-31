package bridge;

public class BigPen extends Pen{

	@Override
	public void draw(String name) {
		String penType = "大号手笔绘制";
		this.color.bepaint(penType, name);
	}

}
