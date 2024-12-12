package time.test;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class TestBetween {

    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 11, 21);

        System.out.println("시작 날짜: " + startDate);
        System.out.println("목표 날짜: " + endDate);
        Period period = Period.between(startDate, endDate);
        System.out.printf("남은 기간: %d년 %d개월 %d일\n", period.getYears(), period.getMonths(), period.getDays());
        System.out.println("디데이: " + ChronoUnit.DAYS.between(startDate, endDate));
    }
}
