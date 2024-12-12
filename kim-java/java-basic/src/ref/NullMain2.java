package ref;

public class NullMain2 {
    public static void main(String[] args) {
        Data data = null; // 가리키는 주소지가 없어 멤버변수에 접근할 수 없음(말이 안됨)
        // data.value = 10; // NullPointerException
        System.out.println("data = " + data.value); // NullPointerException
    }
}
