package time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class GetTimeMain {
    public static void main(String[] args) {
        // get(): 날짜나 시간 조회
        LocalDateTime dt = LocalDateTime.of(2030, 1, 1, 1, 30, 59);
        System.out.println("YEAR = " + dt.get(ChronoField.YEAR));
        System.out.println("MONTH_OF_YEAR = " + dt.get(ChronoField.MONTH_OF_YEAR));
        System.out.println("DAY_OF_MONTH = " + dt.get(ChronoField.DAY_OF_MONTH));
        System.out.println("HOUR_OF_DAY = " + dt.get(ChronoField.HOUR_OF_DAY));
        System.out.println("MINUTE_OF_HOUR = " + dt.get(ChronoField.MINUTE_OF_HOUR));
        System.out.println("SECOND_OF_MINUTE = " + dt.get(ChronoField.SECOND_OF_MINUTE));

        // 대부분은 그냥 이렇게 써도 됨
        System.out.println("편의 메서드 제공");
        System.out.println("YEAR = " + dt.getYear()); // 2030
        System.out.println("MONTH_OF_YEAR = " + dt.getMonthValue()); // 1
        System.out.println("DAY_OF_MONTH = " + dt.getDayOfMonth()); // 1
        System.out.println("HOUR_OF_DAY = " + dt.getHour()); // 1
        System.out.println("MINUTE_OF_HOUR = " + dt.getMinute()); // 30
        System.out.println("SECOND_OF_MINUTE = " + dt.getSecond()); // 59

        // 알아두면 좋은 방식
        System.out.println("편의 메서드에 없음");
        System.out.println("MINUTE_OF_DAY = " + dt.get(ChronoField.MINUTE_OF_DAY)); // 90 (해당일에 지난 시간(분))
        System.out.println("SECOND_OF_DAY = " + dt.get(ChronoField.SECOND_OF_DAY)); // 5459 (해당 일에 지난 시간(초))
    }
}
