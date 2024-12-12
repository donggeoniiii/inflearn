package lang.immutable.address;

public class ImmutableAddress {
    
    // 불변 객체로 만들기 위해 final로 처리(안 넣어도 객체 상태 수정만 안되게 하면 됨)
    private final String value;

    public ImmutableAddress(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // 필드가 final이고 생성자에서 값을 할당하므로 setter 의미 없음
/*
    public void setValue(String value) {
        this.value = value; // compile error
    }
*/

    @Override
    public String toString() {
        return "Address{" +
                "value='" + value + '\'' +
                '}';
    }
}
