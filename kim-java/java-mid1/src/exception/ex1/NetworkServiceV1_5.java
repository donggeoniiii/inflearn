package exception.ex1;

public class NetworkServiceV1_5 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data); // 데이터 추가

        // 정상과 예외 흐름 분리
        try {
            client.connect();
            client.send(data);
        } catch (NetworkClientExceptionV1 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
        } finally {
            // 해당 try-catch 구문에 있어 어찌됐든 이 줄은 반드시 실행됨
            client.disconnect();
        }
    }
}
