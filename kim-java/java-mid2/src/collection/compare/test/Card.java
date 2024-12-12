package collection.compare.test;

public class Card implements Comparable<Card> {
	private final Suit suit;
	private final int rank;

	public Card(Suit suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return rank + "(" + suit.getShape() + ")";
	}

	@Override
	public int compareTo(Card o) {
		// 숫자가 다르면 숫자로 비교
		if (this.rank != o.rank) {
			return this.rank - o.rank;
		}

		// 숫자가 같으면 ♠ -> ♥ -> ♦ -> ♣ 순 정렬
		return this.suit.compareTo(o.suit);
	}
}
