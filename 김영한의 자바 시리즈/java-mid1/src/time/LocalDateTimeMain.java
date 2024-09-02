package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeMain {
    public static void main(String[] args) {
        // 모든 날짜 클래스는 불변, 따라서 반환값을 반드시 받아야 함
        LocalDateTime nowDt = LocalDateTime.now();
        LocalDateTime ofDt = LocalDateTime.of(2018, 11, 2, 10, 0, 1);
        System.out.println("현재 날짜시간= " + nowDt); // yyyy-MM-ddThh:mm:ss.SSS(나노초)
        System.out.println("지정 날짜시간 = " + ofDt); // 입력한 범위까지 나옴(정각이면 초는 생략됨)

        // 날짜(연월일)와 시간(시분초) 분리
        LocalDate localDate = ofDt.toLocalDate();
        LocalTime localTime = ofDt.toLocalTime();
        System.out.println("localDate = " + localDate); // 2018-11-02
        System.out.println("localTime = " + localTime); // 10:00:01

        // 날짜와 시간 합체
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println("localDateTime = " + localDateTime); // 2018-11-02T10:00:01

        // 날짜 계산
        LocalDateTime ofDtPlus = ofDt.plusDays(1000);
        System.out.println("지정 날짜시간 +1000d = "+ ofDtPlus); // 2021-07-29T10:00:01 (1000일 후)
        LocalDateTime ofDtPlus1Year = ofDt.plusYears(1);
        System.out.println("지정 날짜시간 +1년 = " + ofDtPlus1Year); // 2019-11-02T10:00:01 (1년 후)

        // 날짜 비교
        System.out.println("현재 날짜시간이 지정 날짜시간보다 이전인가? -> " + nowDt.isBefore(ofDt)); // false
        System.out.println("현재 날짜시간이 지정 날짜시간보다 이후인가? -> " + nowDt.isAfter(ofDt)); // true
        System.out.println("현재 날짜시간과 지정 날짜시간이 같은가? -> " + nowDt.isEqual(ofDt)); // false

        // isEqual() -> 객체가 가리키는 시간으로 비교, equals() -> 객체의 내부 데이터가 모두 같은지 비교
    }
}
