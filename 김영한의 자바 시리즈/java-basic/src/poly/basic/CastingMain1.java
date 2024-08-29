package poly.basic;

// 다운캐스팅
public class CastingMain1 {
    public static void main(String[] args) {
        // 부모 변수가 자식 인스턴스 참조(다형적 참조)
        Parent poly = new Child();
        // 자식의 기능은 호출할 수 없음
        // poly.childMethod(); // compile error

        // 다운캐스팅: 기존 다형적 참조 변수를 자식 타입으로 형변환
        Child child = (Child) poly; // 새로운 변수 선언해서 poly의 자식 버전 만들기
        child.childMethod(); // 가능

        // 일시적 다운캐스팅: 별도의 변수 선언 안해줘도 됨, poly는 그대로 부모타입
        ((Child) poly).childMethod();
    }
}
