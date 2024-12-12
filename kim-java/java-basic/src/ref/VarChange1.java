package ref;

public class VarChange1 {
    public static void main(String[] args) {
        // 대원칙: Java의 변수는 값을 복사한다
        // 기본형 변수는 변수에 저장된 값을 그대로 가져온다
        int a = 10;
        int b = a;
        System.out.println("a = " + a); // 10
        System.out.println("b = " + b); // 10

        a = 20;
        System.out.println("변경 a = 20");
        System.out.println("a = " + a); // 20
        System.out.println("b = " + b); // 10

        b = 30;
        System.out.println("변경 b = 30");
        System.out.println("a = " + a); // 20
        System.out.println("b = " + b); // 30
    }
}
