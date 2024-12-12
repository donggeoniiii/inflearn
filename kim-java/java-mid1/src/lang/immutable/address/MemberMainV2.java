package lang.immutable.address;

public class MemberMainV2 {

    public static void main(String[] args) {
        ImmutableAddress address = new ImmutableAddress("서울");

        MemberV2 memberA = new MemberV2("회원A", address);
        MemberV2 memberB = new MemberV2("회원B", address);

        // 같은 불변객체로 주소 입력
        System.out.println("memberA = " + memberA); // 서울
        System.out.println("memberB = " + memberB); // 서울

        // 주소 변경을 위해 새 인스턴스 생성해서 변경
        memberB.setAddress(new ImmutableAddress("부산"));
        System.out.println("부산 -> memberB.address");
        System.out.println("memberA = " + memberA); // 서울
        System.out.println("memberB = " + memberB); // 부산
    }
}
