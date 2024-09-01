package lang.math;

public class MathMain {

    public static void main(String[] args) {
        System.out.println("max(10, 20): " + Math.max(10, 20)); // 최대값
        System.out.println("min(10, 20): " + Math.min(10, 20)); // 최소값
        System.out.println("abs(-10): " + Math.abs(-10)); // 절대값

        System.out.println("ceil(2.1): " + Math.ceil(2.1)); // 올림
        System.out.println("floor(2.1): " + Math.floor(2.1)); // 내림
        System.out.println("round(2.5): " + Math.round(2.5)); // 반올림

        System.out.println("sqrt(4): " + Math.sqrt(4)); // 제곱근
        System.out.println("random(): " + Math.random()); // 0.0 ~ 1.0 사이의 무작위 double 값

        // cf) BigDecimal -> 큰 자릿수 다룰 때 유용
    }
}
