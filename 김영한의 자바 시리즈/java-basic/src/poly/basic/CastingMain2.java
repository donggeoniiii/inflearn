package poly.basic;

// 업캐스팅
public class CastingMain2 {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent1 = (Parent) child; // 업캐스팅은 생략 가능(당연), 생략 권장

        parent1.parentMethod();
    }
}
