package exception.ex2;

import exception.ex2.exception.ConnectExceptionV2;
import exception.ex2.exception.SendExceptionV2;

public class NetworkServiceV2_1 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data); // 데이터 추가

        // 정확히 어느 메서드에서 어떤 예외가 발생했는지 확인 가능
        try {
            client.connect();
            client.send(data);
        } catch (ConnectExceptionV2 e) {
            System.out.println("[연결 오류] 주소: " + e.getAddress() + ", 메시지: " + e.getMessage());
        } catch (SendExceptionV2 e) {
            System.out.println("[전송 오류] 전송 데이터: " + e.getSendData() + ", 메시지: " + e.getMessage());
        } /* catch (ConnectExceptionV2 | SendExceptionV2 e) {} -> 이러면 둘다 잡기 가능 */
        finally {
            client.disconnect();
        }

        // 예외를 계층화해서 나누고 말고는 trade-off가 있는 문제다. 적당히가 중요.
    }
}
