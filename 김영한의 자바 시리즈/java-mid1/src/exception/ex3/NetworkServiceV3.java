package exception.ex3;

public class NetworkServiceV3 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV3 client = new NetworkClientV3(address);
        client.initError(data); //추가

        // 다루지 못하는 예외들에 대해 신경 안씀 -> 코드가 깔끔해짐
        try {
            client.connect();
            client.send(data);
        } finally {
            client.disconnect();
        }

    }
}
