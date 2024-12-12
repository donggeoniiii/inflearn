package lang.string;

public class StringConcatMain {
    public static void main(String[] args) {
        String a = "hello";
        String b = " java";

        // 두 문자열 합치기
        String result1 = a.concat(b); // concatenate: 사슬처럼 잇다
        String result2 = a + b; // 위와 같은 의미, 문자열만 가능함
        System.out.println("result1 = " + result1); // hello java
        System.out.println("result2 = " + result2); // hello java
    }
}
