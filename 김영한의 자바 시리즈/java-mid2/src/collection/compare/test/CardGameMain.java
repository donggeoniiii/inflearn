package collection.compare.test;

public class CardGameMain {
    public static void main(String[] args) {
        // 게임 준비
        Deck deck = new Deck();

        // 플레이어 등록
        Player p1 = new Player("플레이어1");
        Player p2 = new Player("플레이어2");

        // 1. 카드 뽑기
        drawCards(p1, deck);
        drawCards(p2, deck);

        // 2. 결과 확인
        String winner = play(p1, p2);

        // 3. 출력
        p1.printHand();
        p2.printHand();
        System.out.println(winner);
    }

    private static void drawCards(Player player, Deck deck) {
        for (int i = 0; i < 5; i++){
            Card card = deck.drawCard();
            player.addCard(card);
        }
    }

    private static String play(Player p1, Player p2) {
        int p1Score = p1.calculateRankSum();
        int p2Score = p2.calculateRankSum();

        if (p1Score > p2Score) {
            return p1.getName() + " 승리";
        }
        else if (p1Score == p2Score) {
            return "무승부";
        }
        else {
            return p2.getName() + " 승리";
        }
    }
}
