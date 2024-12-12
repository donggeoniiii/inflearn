package lang.immutable.address;

public class MemberMainV1 {

    public static void main(String[] args) {
        Address address = new Address("서울");

        // 한 주소로 두명의 회원 정보 기입
        MemberV1 memberA = new MemberV1("회원A", address);
        MemberV1 memberB = new MemberV1("회원B", address);

        // 회원A, 회원B의 처음 주소는 모두 서울
        System.out.println("memberA = " + memberA); // 서울
        System.out.println("memberB = " + memberB); // 서울

        // 한명이 바뀐건데 똑같이 참조해서 둘 다 바뀜
        memberB.getAddress().setValue("부산");
        System.out.println("부산 -> memberB.address"); 
        System.out.println("memberA = " + memberA); // 부산
        System.out.println("memberB = " + memberB); // 부산
    }
}
