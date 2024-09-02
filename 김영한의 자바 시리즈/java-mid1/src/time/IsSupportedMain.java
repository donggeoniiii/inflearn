package time;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class IsSupportedMain {
    public static void main(String[] args) {
        // LocalDate: 날짜 정보(연, 월, 일)만 가지고 있음
        LocalDate now = LocalDate.now();
        // int minute = now.get(ChronoField.SECOND_OF_MINUTE); // 초 못꺼냄 -> UnsupportedTemporalTypeException

        // 적절한 처리를 위한 isSupported(ChronoField)
        boolean supported = now.isSupported(ChronoField.SECOND_OF_MINUTE);
        System.out.println("supported = " + supported); // false
        if (supported) {
            int minute = now.get(ChronoField.SECOND_OF_MINUTE);
            System.out.println("minute = " + minute); // 출력 안됨
        }
    }
}
