package time;

import java.time.temporal.ChronoField;

public class ChronoFieldMain {

    public static void main(String[] args) {
        // ChronoField: 날짜와 시간의 특정 부분을 나타내는데 들어가는 파츠(필드)들. 연, 월, 일 등
        // 8월 16일(Aug 16th)과 8개월 + 16일은 다르다! (Field는 후자)
        ChronoField[] values = ChronoField.values();
        for (ChronoField value : values) {
            System.out.println(value + ", range = " + value.range());
        }

        System.out.println("MONTH_OF_YEAR.range() = " + ChronoField.MONTH_OF_YEAR.range()); // 1 - 12
        System.out.println("DAY_OF_MONTH.range() = " + ChronoField.DAY_OF_MONTH.range()); // 1 - 28/31
    }
}
