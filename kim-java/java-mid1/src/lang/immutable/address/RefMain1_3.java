package lang.immutable.address;

public class RefMain1_3 {
    public static void main(String[] args) {
        Address a = new Address("서울");
        Address b = a; // 같은 참조값
        System.out.println("a = " + a); // 서울
        System.out.println("b = " + b); // 서울

        // b의 참조값에 있는 값을 변경 -> a도 따라감(side effect)
        change(b, "부산");

        System.out.println("a = " + a); // 부산
        System.out.println("b = " + b); // 부산
    }

    // 겉보기엔 그냥 들어오는 주소값을 변경하는 거 같아 보임
    private static void change(Address address, String changeAddress) {
        System.out.println("주소 값을 변경합니다 -> " + changeAddress);
        address.setValue(changeAddress);
    }
}
