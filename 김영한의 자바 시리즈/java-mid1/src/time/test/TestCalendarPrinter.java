package time.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class TestCalendarPrinter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("년도를 입력하세요: ");
        int year = scanner.nextInt();

        System.out.print("월을 입력하세요: ");
        int month = scanner.nextInt();

        printCalendar(year, month);
    }

    private static void printCalendar(int year, int month) {
        StringBuilder sb = new StringBuilder();
        sb.append("Sun Mon Tue Wed Thu Fri Sat").append("\n");

        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        int startIdx = firstDayOfMonth.getDayOfWeek().getValue() % 7; // SUNDAY = 7

        // 간격 맞추기, 요일별 4칸
        for (int i = 0; i < startIdx; i++) {
            sb.append("    ");
        }

        int curDayOfMonth = 1;
        LocalDate curDate = firstDayOfMonth;
        LocalDate lastDateOfMonth = firstDayOfMonth.with(TemporalAdjusters.lastDayOfMonth());
        while (curDate.isBefore(lastDateOfMonth)) {
            // 현재 날짜 입력
            sb.append(String.format("%3d ", curDayOfMonth++));

            // 다음날로 이동
            curDate = curDate.plusDays(1);

            // 다음날이 일요일이면 줄바꿈
            if (curDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
	}
}
