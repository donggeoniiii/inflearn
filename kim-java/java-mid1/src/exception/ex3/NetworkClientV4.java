package exception.ex3;

import exception.ex3.exception.ConnectExceptionV3;
import exception.ex3.exception.SendExceptionV3;

// try-with-resources 방식을 사용하기 위해 AutoClosable 구현
public class NetworkClientV4 implements AutoCloseable {

    private final String address;
    public boolean connectError;
    public boolean sendError;

    public NetworkClientV4(String address) {
        this.address = address;
    }

    public void connect() {
        if (connectError) {
            throw new ConnectExceptionV3(address, address + " 서버 연결 실패");
        }
        // 연결 성공
        System.out.println(address + " 서버 연결 성공");
    }

    public void send(String data) {
        if (sendError) {
            throw new SendExceptionV3(data, address + " 서버에 데이터 전송 실패: " + data);
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

    // close(): try 블럭을 빠져나오면 자동 실행됨
    @Override
    public void close() {
        // System.out.println("NetworkClientV4.close");
        disconnect();
    }
}
