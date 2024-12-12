package time;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class ChangeTimePlusMain {
    public static void main(String[] args) {
        LocalDate dt = LocalDate.of(2018, 1, 1);
        System.out.println("dt = " + dt);

        // ChronoUnit과 함께 사용
        LocalDate plusDt1 = dt.plus(10, ChronoUnit.YEARS);
        System.out.println("plusDt1 = " + plusDt1); // 2028-01-01

        // 그냥 이렇게 써도 됨
        LocalDate plusDt2 = dt.plusYears(10);
        System.out.println("plusDt2 = " + plusDt2); // 2028-01-01

        // Period와 함께 쓰기
        Period period = Period.ofYears(10);
        LocalDate plusDt3 = dt.plus(period);
        System.out.println("plusDt3 = " + plusDt3); // 2028-01-01
    }
}
