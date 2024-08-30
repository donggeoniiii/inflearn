package lang.string;

public class StringImmutableMain {

    public static void main(String[] args) {
        // String은 불변객체(문자열 풀로 이어진 다른 변수들 때문)
        String str = "hello";
        str.concat(" java"); // 이렇게 쓰면 날아감(불변객체라 수정돼서 오는 반환값을 받아주어야 함)
        str = str.concat(" java");
        System.out.println("str = " + str);
    }
}
