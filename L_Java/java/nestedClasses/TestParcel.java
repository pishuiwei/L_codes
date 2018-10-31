package nestedClasses;

public class TestParcel {
	public static void main(String[] args) {
//		Parce14 p = new Parce14();
//		Contents c= p.contents();
//		Destination d = p.destination("Tasmania");
	}
}

class Parce14 {
	private class PContents implements Contents {
		private int i = 11;

		public int value() {
			return i;
		}
	}

	protected class PDestination implements Destination {
		private String label;

		private PDestination(String whereTo) {
			label = whereTo;
		}

		public String readLabel() {
			return label;
		}
	}
	public Destination destination(String s) {
		return new PDestination(s);
	}
	public Contents contents() {
		return new PContents();
	}
}