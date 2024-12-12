package exception.basic.checked;

public class Service {
    Client client = new Client();
    /**
     * 예외를 잡아서 처리하는 코드
     */
    public void callCatch() {
        // client.call(); // MyCheckedException

        // try 블럭 실행 중 exception 발생 시 catch문 실행 후 진행
        try {
            client.call();
            System.out.println("no exception!"); // 윗줄에서 예외가 터지면 실행 안됨
        } /* catch (Exception e) {
            // 특별히 자세하게 처리하고 싶은 예외가 있다면 상위 예외가 던져지기 전에 처리한다
            e.printStackTrace();
        } */ catch (MyCheckedException e) {
            // 예외 처리 로직 입력
            System.out.println("예외 처리, message = " + e.getMessage());
        }
        System.out.println("정상 흐름");
    }

    /**
     * 체크 예외를 밖으로 던지는 코드
     * 체크 예외는 예외를 잡지 않고 밖으로 던지려면 throws 예외를 메서드에 필수로 선언해야 한다.
     */
    public void catchThrow() throws MyCheckedException {
        client.call();
    }

    // 체크 예외는 잡거나, 던지거나 둘 중 하나를 반드시 선택해야 함(안 그러면 컴파일러가 체크해서 안돌아감)
}