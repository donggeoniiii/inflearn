package exception.ex1;

public class NetworkServiceV1_1 {

    public void sendMessage(String data) throws NetworkClientExceptionV1 {
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data); // 데이터 추가

        // 예외처리 떠넘겨서 main에서 터질 위험성
        client.connect();
        client.send(data);
        client.disconnect();
    }
}
