package exception.ex2.exception;

// 연결 실패 예외, 네트워크 예외 클래스를 상속받음(얘도 객체니까 가능)
public class ConnectExceptionV2 extends NetworkClientExceptionV2 {

    private final String address;

    public ConnectExceptionV2(String address, String message) {
        super(message);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
