package time.test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TestZone {

    public static void main(String[] args) {
        LocalDateTime seoulLocalTime = LocalDateTime.of(2024, 1, 1, 9, 0);
        ZonedDateTime seoulTime = ZonedDateTime.of(seoulLocalTime, ZoneId.of("Asia/Seoul"));
        ZonedDateTime londonTime = seoulTime.withZoneSameInstant(ZoneId.of("Europe/London"));
        ZonedDateTime newYorkTime = seoulTime.withZoneSameInstant(ZoneId.of("America/New_York"));

        System.out.println("서울의 회의 시간: " + seoulTime);
        System.out.println("런던의 회의 시간: " + londonTime);
        System.out.println("뉴욕의 회의 시간: " + newYorkTime);
    }
}
