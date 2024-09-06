package exception.ex1;

public class NetworkClientV1 {

    private final String address;
    public boolean connectError;
    public boolean sendError;

    public NetworkClientV1(String address) {
        this.address = address;
    }

    public void connect() throws NetworkClientExceptionV1 {
        if (connectError) {
            throw new NetworkClientExceptionV1("connectError", address + " 서버 연결 실패");
        }
        // 연결 성공
        System.out.println(address + " 서버 연결 성공");
    }

    public void send(String data) throws NetworkClientExceptionV1 {
        if (sendError) {
            throw new NetworkClientExceptionV1("sendError", address + " 서버에 데이터 전송 실패: " + data);
            // 중간에 다른 예외가 발생할 수도 있음
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
