package time;

import java.time.ZoneId;

public class ZoneIdMain {

    public static void main(String[] args) {
        // 타임존 전체 출력
        for (String availableZoneId : ZoneId.getAvailableZoneIds()) {
            ZoneId zoneId = ZoneId.of(availableZoneId);
            System.out.println(zoneId + " | " + zoneId.getRules()); // Asia/Seoul | ZoneRules[currentStandardOffset=+09:00]
        }

        // 특정 타임존
        ZoneId seoulZoneId = ZoneId.of("Asia/Seoul");
        System.out.println("seoulZoneId = " + seoulZoneId); // Asia/Seoul
        
        // 시스템 달력 기준 타임존
        ZoneId zoneId = ZoneId.systemDefault(); 
        System.out.println("ZoneId.systemDefault = " + zoneId); // Asia/Seoul
    }
}
