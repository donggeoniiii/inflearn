package enumeration.ex0;

public class StringGradeEx0 {

    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();

        // 존재하지 않는 등급
        int vip = discountService.discount("VIP", price);
        System.out.println("VIP 등급의 할인 금액: " + vip); // 할인X

        // 오타 이슈
        int diamondd = discountService.discount("DIAMONDD", price);
        System.out.println("DIAMONDD 등급의 할인 금액: " + vip); // 할인X

        // 데이터 일관성 부족(소문자 입력 등)
        int gold = discountService.discount("gold", price);
        System.out.println("gold 등급의 할인 금액: " + gold); // 할인X

        // 제일 큰 문제: 이런 문제들을 컴파일 하기 전까지 알 수 없음
    }
}
