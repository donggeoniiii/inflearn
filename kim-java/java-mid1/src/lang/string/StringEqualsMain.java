package lang.string;

public class StringEqualsMain {

    public static void main(String[] args) {
        // 문자열 인스턴스 비교
        String str1 = new String("hello");
        String str2 = new String("hello");

        // 동일성: 둘은 다른 인스턴스이므로 다름
        System.out.println("new String() == 비교: " + (str1 == str2)); // false
        // 동등성: 논리적으로 둘다 hello라고 읽힘
        System.out.println("new String() equals 비교:" + (str1.equals(str2))); // true

        // 리터럴 비교
        String str3 = "hello";
        String str4 = "hello";

        /*
         문자열 풀(string pool): 문자열 리터럴을 처음 보면 최적화를 위해 보관해둠
         이후 다음에 같은 리터럴을 보면 보관해둔 참조위치 반환
         */

        // 동일성: 문자열 풀에서 같은 인스턴스를 참조하게 됨
        System.out.println("리터럴 == 비교: " + (str3 == str4)); // true
        // 동등성: 논리적으로 둘다 hello라고 읽힘
        System.out.println("리터럴 equals 비교: " + (str3.equals(str4))); // true

        // 리터럴로 들어온 경우엔 ==로 비교해도 되지만, 헷갈리니까 문자열은 equals로 비교하자
    }
}
