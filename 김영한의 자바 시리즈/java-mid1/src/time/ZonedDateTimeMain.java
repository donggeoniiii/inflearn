package time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeMain {
    public static void main(String[] args) {
        ZonedDateTime nowZdt = ZonedDateTime.now();
        System.out.println("nowZdt = " + nowZdt); // yyyy-MM-ddThh-mm-ss.SSS(타임존 정보)

        // ZonedDateTime = LocalDateTime + ZoneId
        LocalDateTime ldt = LocalDateTime.of(2018, 11, 2, 13, 0, 1);
        ZonedDateTime zdt1 = ZonedDateTime.of(ldt, ZoneId.of("Asia/Seoul")); // 타임존은 무조건 앞글자 대문자
        System.out.println("zdt1 = " + zdt1); // 2018-11-02T13:00:01+09:00[Asia/Seoul]

        // 리터럴로 한번에 생성할거면 나노초까지 넣어야
        ZonedDateTime zdt2 = ZonedDateTime.of(2018, 11, 2, 13, 0, 1, 0, ZoneId.of("Asia/Seoul"));
        System.out.println("zdt2 = " + zdt2);// 2018-11-02T13:00:01+09:00[Asia/Seoul]

        // 타임존 변경(해당 시간에 다른 나라는 몇시인지)
        ZonedDateTime utcZdt = zdt2.withZoneSameInstant(ZoneId.of("UTC"));
        System.out.println("utcZdt = " + utcZdt); // 2018-11-02T04:00:01Z[UTC]
    }
}
