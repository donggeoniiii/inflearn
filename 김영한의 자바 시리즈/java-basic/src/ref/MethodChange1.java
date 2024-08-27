package ref;

public class MethodChange1 {
    public static void main(String[] args) {
        int a = 10;
        System.out.println("메서드 호출 전: a = " + a); // 10
        changePrimitive(a); // 10이라는 실제값이 대입됐을 뿐, a가 가리키는 값은 변하지 않음
        System.out.println("메서드 호출 후: a = " + a); // 10
    }

    static void changePrimitive(int x) {
        x = 20;
    }
}
