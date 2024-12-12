package collection.compare.test;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private final String name;
	private final List<Card> hand = new ArrayList<>();

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addCard(Card card) {
		hand.add(card);
	}

	public int calculateRankSum() {
		int score = 0;
		for (Card c : hand) {
			score += c.getRank();
		}
		return score;
	}

	public void printHand() {
		hand.sort(null);

		StringBuilder sb = new StringBuilder();
		sb.append(name).append("의 카드: ").append(hand)
			.append(", 합계: ").append(calculateRankSum());
		System.out.println(sb);
	}
}
