package time.test;

import java.time.LocalDate;
public class TestLoopPlus {

    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2024, 1, 1);

        for (int i = 0; i < 5; i++) {
            startDate = startDate.plusWeeks(2 * i);
            System.out.println("날짜 " + (i+1) + ": " + startDate);
        }
    }
}
