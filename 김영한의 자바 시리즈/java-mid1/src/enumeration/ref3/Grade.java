package enumeration.ref3;

public enum Grade {
    BASIC(10), GOLD(20), DIAMOND(30), PLATINUM(40);

    private final int discountPercent;

    Grade(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    // public int getDiscountPercent() {
    //     return discountPercent;
    // }

    // 본인의 데이터(할인율)를 가지고 계산하니까 그냥 내부에 메소드 들고 있기
    public int discount(int price) {
        return price * discountPercent / 100;
    }

    public void printDiscount(int price) {
        System.out.println(this.name() + " 등급의 할인 금액: " + this.discount(price));
    }
}
