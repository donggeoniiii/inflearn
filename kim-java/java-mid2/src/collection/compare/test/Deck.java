package collection.compare.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Deck {
	private Queue<Card> cards;

	public Deck() {
		cards = initDeck();
	}

	private ArrayDeque<Card> initDeck() {
		List<Card> cardList = new ArrayList<>();
		for (int i = 1; i <= 13; i++) {
			cardList.add(new Card(Suit.SPADE, i));
			cardList.add(new Card(Suit.HART, i));
			cardList.add(new Card(Suit.DIAMOND, i));
			cardList.add(new Card(Suit.CLUB, i));
		}
		Collections.shuffle(cardList);
		return new ArrayDeque<>(cardList);
	}

	public Card drawCard() {
		return cards.poll();
	}
}
