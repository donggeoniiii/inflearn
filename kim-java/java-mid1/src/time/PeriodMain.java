package time;

import java.time.LocalDate;
import java.time.Period;

public class PeriodMain {
    public static void main(String[] args) {
        // Period: 날짜 차이
        Period period = Period.ofDays(10); // 10일 차이
        System.out.println("period = " + period); // P10D

        // 계산에 사용
        LocalDate currentDate = LocalDate.of(2024, 9, 2);
        LocalDate plusDate = currentDate.plus(period); // 10일 차이 추가
        System.out.println("currentDate = " + currentDate); // 2024-09-02
        System.out.println("plusDate = " + plusDate); // 2024-09-12

        // 기간 차이
        LocalDate startDate = LocalDate.of(2023, 1, 30);
        LocalDate endDate = LocalDate.of(2023, 3, 2);
        Period between = Period.between(startDate, endDate);
        System.out.println("기간: " + between.getMonths() + "개월 " + between.getDays() + "일"); // 1개월 2일
    }
}
