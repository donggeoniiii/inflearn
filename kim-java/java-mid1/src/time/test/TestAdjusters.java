package time.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TestAdjusters {

    public static void main(String[] args) {
        int year = 2024;
        int month = 1;

        LocalDate firstDay = LocalDate.of(year, month, 1);
        DayOfWeek firstDayOfWeek = firstDay.getDayOfWeek();
        DayOfWeek lastDayOfWeek = firstDay.with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek();

        System.out.println("firstDatOfWeek = " + firstDayOfWeek);
        System.out.println("lastDatOfWeek = " + lastDayOfWeek);
    }
}
