package exception.ex1;

public class NetworkServiceV1_2 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data); // 데이터 추가

        // 여전히 정상 흐름과 예외 흐름이 분리가 안되어 있음
        try {
			client.connect();
		} catch (NetworkClientExceptionV1 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
		}
		try {
			client.send(data);
        } catch (NetworkClientExceptionV1 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
        }

		client.disconnect();
    }
}
