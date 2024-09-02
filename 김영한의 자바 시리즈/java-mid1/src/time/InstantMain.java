package time;

import java.time.Instant;
import java.time.ZonedDateTime;

public class InstantMain {
    public static void main(String[] args) {
        Instant now = Instant.now(); // UTC 기준 현재 시간(타임존 영향 x)
        System.out.println("now = " + now);

        // ZonedDateTime에서 뽑아서 변환도 가능(UTC 기준으로 변환됨)
        ZonedDateTime zdt = ZonedDateTime.now();
        Instant from = Instant.from(zdt);
        System.out.println("from = " + from);

        // Instant: 1970년 1월 1일 자정 기준 경과한 시간
        Instant epochStart = Instant.ofEpochSecond(0);
        System.out.println("epochStart = " + epochStart); // 1970-01-01T00:00:00Z

        // 계산
        Instant later = epochStart.plusSeconds(3600); // 1시간 경과
        System.out.println("later = " + later); // 1970-01-01T01:00:00Z

        // 시작시간(700101 0시 정각) 기준 흐른 시간(초) 조회
        long laterEpochSecond = later.getEpochSecond();
        System.out.println("laterEpochSecond = " + laterEpochSecond); // 3600
    }
}
