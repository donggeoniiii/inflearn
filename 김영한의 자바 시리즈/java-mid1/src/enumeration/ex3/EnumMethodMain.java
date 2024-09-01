package enumeration.ex3;

import java.util.Arrays;

public class EnumMethodMain {
    public static void main(String[] args) {
        // 모든 ENUM 반환
        Grade[] values = Grade.values();
        System.out.println(Arrays.toString(values)); // [BASIC, GOLD, DIAMOND]
        System.out.println(Grade.valueOf("BASIC")); // BASIC
        // System.out.println(Grade.valueOf("BASIC1")); // 잘못된 입력 -> IllegalArgumentException

        // 순서대로 출력(enum 파일에 열거된 순서)
        for (Grade value : values) {
            System.out.println(value.name() + " = " + value.ordinal());
        } // BASIC = 0, GOLD = 1, DIAMOND = 2
        // ordinal()의 값은 열거 순서에 의존하므로 가급적 지양하는 걸로

        // String -> ENUM 변환
        String input = "GOLD";
        Grade gold = Grade.valueOf(input);
        System.out.println(gold); // GOLD

        // Grade diamond = Grade.valueOf("diamond"); // 잘못된 입력 -> IllegalArgumentException
        Grade diamond = Grade.valueOf("DIAMOND");
        System.out.println(diamond); // DIAMOND
    }
}
