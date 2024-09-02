package time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class ChangeTimeWithMain {
	public static void main(String[] args) {
		LocalDate dt = LocalDate.of(2024, 9, 2);
		System.out.println("dt = " + dt);

		// 연도 바꾸기, 불변객체라 with(ChronoField)
		LocalDate changedDt1 = dt.with(ChronoField.YEAR, 2020);
		System.out.println("changedDt1 = " + changedDt1); // 2020-09-02

		// 이거 써도 됨
		LocalDate changedDt2 = dt.withYear(2020);
		System.out.println("changedDt2 = " + changedDt2); // 2020-09-02

		// TemporalAdjuster 사용, with(ChronoField)
		LocalDate with1 = dt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)); // 다음 금요일
		System.out.println("기준 날짜: " + dt); // 2024-09-02
		System.out.println("다음 금요일: " + with1); // 2024-09-06

		LocalDate with2 = dt.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY)); // 이달의 마지막 일요일
		System.out.println("같은 달의 마지막 일요일 = " + with2); // 2024-09-29
	}
}
