package collection.compare.test;

// enum은 열거 순서(ordinal)가 natural order
public enum Suit {
	SPADE("♠"),
	HART("♥"),
	DIAMOND("♦"),
	CLUB("♣");

	private final String shape;

	Suit(String shape) {
		this.shape = shape;
	}

	public String getShape() {
		return shape;
	}
}
