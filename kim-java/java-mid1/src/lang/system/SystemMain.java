package lang.system;

import java.util.Arrays;

public class SystemMain {

    public static void main(String[] args) {
        // 현재 시간(밀리초)
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis = " + currentTimeMillis);

        // 현재 시간(나노초)
        long currentTimeNano = System.nanoTime();
        System.out.println("currentTimeNano = " + currentTimeNano);

        // 환경 변수 반환
        System.out.println("getenv= " + System.getenv());

        // 시스템 속성 반환
        System.out.println("properties = " + System.getProperties());
        System.out.println("Java version: " + System.getProperty("java.version")); // java 버전만 가져오기

        // 배열 고속 복사(반복문을 도는게 아니라 통째로 복사)
        char[] originalArray = {'h', 'e', 'l', 'l', 'o'};
        char[] copiedArray = new char[5];
        System.arraycopy(originalArray, 0, copiedArray, 0, originalArray.length);

        // 배열 출력
        System.out.println(copiedArray); // 참조값 나옴
        System.out.println(Arrays.toString(copiedArray)); // [h, e, l, l, o]

        // 프로그램 종료(사용 권장 x)
        System.exit(0);
    }
}
