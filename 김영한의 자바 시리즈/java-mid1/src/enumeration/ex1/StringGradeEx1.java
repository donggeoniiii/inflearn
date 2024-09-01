package enumeration.ex1;

public class StringGradeEx1 {

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

        /*
            파라미터로 문자열을 받으니까 뭘 해도 검출 안됨
            새로운 방법이 필요하다!
         */
    }
}
