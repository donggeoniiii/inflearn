package lang.immutable.address;

public class RefMain1_2 {
    public static void main(String[] args) {
        // 처음부터 다른 값을 참조하게 하기
        Address a = new Address("서울");
        Address b = new Address("서울");
        System.out.println("a = " + a); // 서울
        System.out.println("b = " + b); // 서울

        b.setValue("부산"); // a와 b는 서로 다른 객체, 각자 값 유지
        System.out.println("부산 -> b");
        System.out.println("a = " + a); // 서울
        System.out.println("b = " + b); // 부산
    }
}
