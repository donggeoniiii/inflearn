package exception.ex1;

import java.util.Scanner;

public class MainV1 {

    public static void main(String[] args) throws NetworkClientExceptionV1 {
        // NetworkServiceV1_1 networkService = new NetworkServiceV1_1();
        // NetworkServiceV1_2 networkService = new NetworkServiceV1_2();
        // NetworkServiceV1_3 networkService = new NetworkServiceV1_3();
        // NetworkServiceV1_4 networkService = new NetworkServiceV1_4();
        NetworkServiceV1_5 networkService = new NetworkServiceV1_5();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("전송할 문자: ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            networkService.sendMessage(input);
            System.out.println();
        }
        System.out.println("프로그램을 정상 종료합니다.");
    }
}
