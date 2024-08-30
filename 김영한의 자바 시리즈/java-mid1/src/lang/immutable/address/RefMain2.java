package lang.immutable.address;

public class RefMain2 {
    public static void main(String[] args) {
        ImmutableAddress a = new ImmutableAddress("서울");
        ImmutableAddress b = a; // 참조값 대입은 어쩔 수 없음
        System.out.println("a = " + a); // 서울
        System.out.println("b = " + b); // 서울

        // b.setValue("부산"); // compile error, 수정 안됨
        b = new ImmutableAddress("부산"); // 값을 못 바꾸니 새로운 인스턴스 대입
        System.out.println("부산 -> b");
        System.out.println("a = " + a); // 서울
        System.out.println("b = " + b); // 부산
    }
}
