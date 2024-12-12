package lang.object.tostring;

public class ToStringMain1 {
    public static void main(String[] args) {
        Object object = new Object();
        String string = object.toString();

        // toString() 반환값: 객체의 클래스 정보@참조값(16진수)
        System.out.println(string); // java.lang.Object@b4c966a

        // object 직접 출력
        System.out.println(object); // 위와 동일, println()이 내부에서 toString()을 호출한다.
    }

}
