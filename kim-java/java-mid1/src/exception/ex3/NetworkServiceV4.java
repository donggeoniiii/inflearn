package exception.ex3;

public class NetworkServiceV4 {

    public void sendMessage(String data) {
        String address = "http://example.com";

        // try-with-resources: finally 구문 없이 외부 자원 close 해줌
        try (NetworkClientV4 client = new NetworkClientV4(address)) {
            client.initError(data); // 추가
            client.connect();
            client.send(data);
        } catch (Exception e) {
            System.out.println("[예외 확인]: " + e.getMessage());
            throw e;
        }
    }
}
