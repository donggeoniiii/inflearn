package lang.string.test;

public class TestString9 {

    public static void main(String[] args) {
        String email = "hello@example.com";
        String[] answer = email.split("@");
        System.out.println("ID: " + answer[0]);
        System.out.println("Domain: " + answer[1]);
    }
}
