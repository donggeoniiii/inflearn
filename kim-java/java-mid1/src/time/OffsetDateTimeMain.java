package time;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class OffsetDateTimeMain {
    public static void main(String[] args) {
        OffsetDateTime nowOdt = OffsetDateTime.now();
        System.out.println("nowOdt = " + nowOdt); // yy-MM-ddThh:mm:ss.SSS(오프셋)

        // OffsetDateTime = LocalDateTime + ZoneOffset(서머타임 적용 x)
        LocalDateTime ldt = LocalDateTime.of(2018, 11, 2, 15, 0, 1);
        System.out.println("ldt = " + ldt); // 2018-11-02T15:00:01
        OffsetDateTime odt = OffsetDateTime.of(ldt, ZoneOffset.of("+01:00"));
        System.out.println("odt = " + odt); // 2018-11-02T15:00:01+01:00
    }
}
