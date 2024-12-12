package exception.ex3;

import exception.ex3.exception.SendExceptionV3;

import java.util.Scanner;

public class MainV3 {
    public static void main(String[] args) {
        // NetworkServiceV3 networkService = new NetworkServiceV3();
        NetworkServiceV4 networkService = new NetworkServiceV4();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("전송할 문자: ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }

            try {
                networkService.sendMessage(input);
            } catch (Exception e) {
                exceptionHandler(e); // 대처 안되는 예외들 공통 처리
            }
            System.out.println();
        }
        System.out.println("프로그램을 정상 종료합니다.");
    }

    // 잡지 않을 예외들 공통으로 처리하는 메서드 분리
    private static void exceptionHandler(Exception e) {
        // 공통 처리 - 사용자 화면 출력
        System.out.println("사용자 메시지: 죄송합니다. 알 수 없는 문제가 발생했습니다.");

        // 공통 처리 - 개발자에게 디버깅 메시지 전송
        System.out.println("==개발자용 디버깅 메시지==");
        e.printStackTrace(System.out); // 스택 트레이스 출력
        // e.printStackTrace(); // 이러면 빨간색 글씨로 표시해줌(우리가 아는 그 내용)
        // 어차피 이건 실무 가면 Slf4J같은 로그 라이브러리를 쓸거임

        // 예외별 추가 처리 가능(필요하다면)
        if (e instanceof SendExceptionV3 sendEx) {
            System.out.println("[전송 오류] 전송 데이터: " + sendEx.getSendData());
        }
    }
}
