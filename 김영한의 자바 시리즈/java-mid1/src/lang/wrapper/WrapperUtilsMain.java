package lang.wrapper;

public class WrapperUtilsMain {
    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(10); // 정수 리터럴 to wrapper 객체
        Integer i2 = Integer.valueOf("10"); // 문자열 to wrapper 객체
        int intValue = Integer.parseInt("10"); // 문자열 to 기본형

        // 비교 메서드 제공
        int compareResult = i1.compareTo(20);
        System.out.println("compareResult = " + compareResult);

        // 산술 연산 메서드 제공(static)
        System.out.println("sum: " + Integer.sum(10, 20));
        System.out.println("min: " + Integer.min(10, 20));
        System.out.println("max: " + Integer.max(10, 20));
    }
}
