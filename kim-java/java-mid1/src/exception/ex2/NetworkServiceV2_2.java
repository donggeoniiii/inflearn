package exception.ex2;

import exception.ex2.exception.ConnectExceptionV2;
import exception.ex2.exception.NetworkClientExceptionV2;

public class NetworkServiceV2_2 {
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data); // 데이터 추가

        // 상속 관계를 이용해서 여러 예외를 한번에 잡을 수 있음
        try {
            client.connect();
            client.send(data);
        } catch (ConnectExceptionV2 e) {
            // 작은 예외가 상단 catch 절에 있어야 함(안 그럼 무시당함)
            System.out.println("[연결 오류] 주소: " + e.getAddress() + ", 메시지: " + e.getMessage());
        } catch (NetworkClientExceptionV2 e) {
            System.out.println("[네트워크 오류] 메시지: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[알 수 없는 오류] 메시지: " + e.getMessage());
        } finally {
            client.disconnect();
        }

    }
}
