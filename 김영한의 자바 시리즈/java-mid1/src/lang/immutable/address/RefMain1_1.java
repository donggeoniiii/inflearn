package lang.immutable.address;

public class RefMain1_1 {

    public static void main(String[] args) {
        // 참조형 변수는 참조값을 들고 있어서 하나의 인스턴스를 공유할 수 있다.
        Address a = new Address("서울");
        Address b = a; // a와 b는 같은 값을 보게 됨
        System.out.println("a = " + a); // 서울
        System.out.println("b = " + b); // 서울

        b.setValue("부산"); // b의 값 변경 -> a도 바뀜
        System.out.println("부산 -> b");
        System.out.println("a = " + a); // 부산
        System.out.println("b = " + b); // 부산
    }
}
