package poly.basic;

// 다운캐스팅은 명시적으로 해야 하는 이유
public class CastingMain3 {
    public static void main(String[] args) {
        // 다형적 참조 -> 인스턴스가 작은 타입(자식)이므로 다운캐스팅 가능
        Parent parent1 = new Child();
        Child child1 = (Child) parent1;
        child1.childMethod(); // 문제 없음

        // 부모 변수가 부모 인스턴스 참조 -> 변환할 자식 인스턴스가 없어 다운캐스팅 불가
        Parent parent2 = new Parent();
        // Child child2 = (Child) parent2; // 런타임 오류 - ClassCastException
    }
}
