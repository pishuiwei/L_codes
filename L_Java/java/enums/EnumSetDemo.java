package enums;

import java.util.EnumSet;

public class EnumSetDemo {

	public static void main(String[] args) {
		EnumSet<Color> eColors = EnumSet.allOf(Color.class);
		for(Color color : eColors) {
			System.out.println("name: " + color.getName() + "\tindex: " + color.getIndex());
		}
	}
}
