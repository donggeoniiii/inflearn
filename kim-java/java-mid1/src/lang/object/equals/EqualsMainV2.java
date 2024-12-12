package lang.object.equals;

public class EqualsMainV2 {

    public static void main(String[] args) {
        UserV2 user1 = new UserV2("id-100");
        UserV2 user2 = new UserV2("id-100");

        // 동일성(==): 두 객체가 같은 값을 참조한다
        System.out.println("identity = " + (user1 == user2)); // 두 인스턴스가 서로 다르므로 false

        // 동등성(equals()): 두 객체가 논리적으로 같다
        System.out.println("equality = " + user1.equals(user2)); // id가 서로 같으므로 true
    }
}