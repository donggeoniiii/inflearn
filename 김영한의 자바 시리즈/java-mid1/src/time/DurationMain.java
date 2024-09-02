package time;

import java.time.Duration;
import java.time.LocalTime;

public class DurationMain {
    public static void main(String[] args) {
        // Duration: 시간 차이
        Duration duration = Duration.ofMinutes(30); // 30분 차이
        System.out.println("duration = " + duration); // PT30M

        LocalTime lt = LocalTime.of(1, 0);
        System.out.println("lt = " + lt); // 01:00

        // 계산에 사용
        LocalTime plusTime = lt.plus(duration); // 30분 지남
        System.out.println("더한 시간: " + plusTime); // 01:30

        // 시간 차이
        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(10, 0);
        Duration between = Duration.between(start, end); // 1시간 차이
        System.out.println("차이: " + between.getSeconds() + "초"); // 3600초
        System.out.println("근무 시간: " + between.toHours() + "시간" + between.toMinutesPart() + "분"); // 1시간 0분

    }
}
