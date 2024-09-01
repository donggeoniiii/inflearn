package enumeration.ex2;

public class ClassGradleEx2 {

    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();

        // ClassGrade newClassGrade = new ClassGrade(); // 생성자 막힘
        int result = discountService.discount(ClassGrade.BASIC, price);
        System.out.println("BASIC 등급의 할인 금액: " + result); // 1000

    }
}
