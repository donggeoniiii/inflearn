package final1.ex;

public class MemberMain {
    public static void main(String[] args) {
        Member member = new Member("myId", "kim");
        member.print(); // id: myId, name: kim
        member.changeData("myId2", "seo"); // 이렇게 입력해도 안 바뀜
        member.print(); // id: myId, name: seo
    }
}
