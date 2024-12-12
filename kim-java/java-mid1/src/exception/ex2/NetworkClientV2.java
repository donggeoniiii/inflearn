package exception.ex2;

import exception.ex2.exception.ConnectExceptionV2;
import exception.ex2.exception.SendExceptionV2;

public class NetworkClientV2 {

    private final String address;
    public boolean connectError;
    public boolean sendError;

    public NetworkClientV2(String address) {
        this.address = address;
    }

    public void connect() throws ConnectExceptionV2 {
        if (connectError) {
            throw new ConnectExceptionV2(address, address + " 서버 연결 실패");
        }
        // 연결 성공
        System.out.println(address + " 서버 연결 성공");
    }

    public void send(String data) throws SendExceptionV2 {
        if (sendError) {
            throw new SendExceptionV2(data, address + " 서버에 데이터 전송 실패: " + data);
            // throw new RuntimeException("ex");
        }
        // 전송 성공
        System.out.println(address + " 서버에 데이터 전송: " + data);
    }

    public void disconnect() {
        System.out.println(address + " 서버 연결 해제");
    }

    public void initError(String data) {
        if (data.contains("error1")) {
            connectError = true;
        }
        if (data.contains("error2")) {
            sendError = true;
        }
    }
}
