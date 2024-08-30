package lang.string;

public class StringBasicMain {

    public static void main(String[] args) {
        String str1 = "hello";
        // 얘도 클래스라 원래는 이렇게 돼야 함, java가 위처럼 넣어도 바꿔주는 것
        String str2 = new String("hello");

        System.out.println("str1 = " + str1); // hello
        System.out.println("str2 = " + str2); // hello
    }
}
