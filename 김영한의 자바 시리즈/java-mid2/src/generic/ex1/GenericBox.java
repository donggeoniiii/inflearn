package generic.ex1;

// 제네릭 클래스: 클래스명 옆에 <> 사용
public class GenericBox<T> {

    // T: 타입 매개변수. 타입 이름이 필요한 곳에 적으면 됨
    // 다른 알파벳이어도 되지만 Type의 T를 사용하는게 관례
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}