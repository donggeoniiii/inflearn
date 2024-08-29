package final1;

public class FieldInit {
    // 상수 선언: 모든 인스턴스가 공통된 값에 접근 가능하며 메모리도 효율적으로 사용 가능
    static final int CONST_VALUE = 10;

    // 필드 초기화
    final int value = 10;

    // 생성자를 이용해도 변경 안됨
    FieldInit() {
        // value = 30; // compile error
    }
}
