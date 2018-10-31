package nestedClasses;

public class Parce13 {

	class Contents {
		private int i = 11;

		public int value() {
			return i;
		};
	}

	class Destination {
		private String label;
		Destination(String whereTo) {
			label = whereTo;
		}
		String readLabel(){ return label; };
	}
}



