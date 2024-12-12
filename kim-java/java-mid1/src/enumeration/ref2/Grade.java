package enumeration.ref2;

// 인터페이스처럼 좀 특이한 형태의 클래스라고 생각하기
// 인터페이스 구현도 됨(상속은 이미 java.lang.Enum을 받은 상태)
public enum Grade {
    BASIC(10), GOLD(20), DIAMOND(30);

    // 필드로 할인율 들고 있게 하기
    private final int discountPercent;

    Grade(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }
}
