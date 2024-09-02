package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormattingMain {

    public static void main(String[] args) {
        // formatting: 날짜 -> 문자
        LocalDateTime date = LocalDateTime.of(2024, 12, 31, 23, 30, 10);
        System.out.println("date = " + date); // 2024-12-31T23:30:10
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
        String formattedDate = date.format(formatter);
        System.out.println("날짜와 시간 포맷팅 = " + formattedDate); // 2024년 12월 31일 23시 30분

        // parsing: 문자 -> 날짜
        String input = "2024년 12월 31일 23시 30분 10초";
        LocalDate parsedDate = LocalDate.parse(input, formatter);
        System.out.println("문자열 파싱 날짜와 시간: " + parsedDate); // 2024-12-31 (뒤에는 LocalDate 타입이므로 없음)
        
        // 패턴은 공식 사이트를 보면 지정하기 쉽다. 엄청 다양함
    }
}
