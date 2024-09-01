package enumeration.ref1;

public class DiscountService {

    public int discount(ClassGrade classGrade, int price) {
        // 할인율은 열거형 변수가 들고 있으므로 따로 코드가 추가될 필요 없음 
        return price * classGrade.getDiscountPercent() / 100;
    }
}
