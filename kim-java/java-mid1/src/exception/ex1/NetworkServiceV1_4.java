package exception.ex1;

public class NetworkServiceV1_4 {

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
        }

        // 근데 만약 다른데서 예상치 못한 다른 예외가 터진다면? -> 이거 실행 안될 수도
        client.disconnect();
    }
}
