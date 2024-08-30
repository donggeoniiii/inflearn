package lang.immutable.change;

public class ImmutableObj {

    // 맘대로 수정할 수 없게 final 처리
    private final int value;

    public ImmutableObj(int value) {
        this.value = value;
    }

    // 값 수정x, 대신 새로운 값을 가진 불변객체로 반환
    public ImmutableObj add(int addValue) {
        int result = value + addValue;
        return new ImmutableObj(result);
    }

    public int getValue() {
        return value;
    }
}
