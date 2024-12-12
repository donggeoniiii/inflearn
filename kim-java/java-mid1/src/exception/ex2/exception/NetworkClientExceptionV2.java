package exception.ex2.exception;

// 연결실패, 전송실패 예외 둘다 처리하는 부모 예외 클래스
public class NetworkClientExceptionV2 extends Exception {
    public NetworkClientExceptionV2(String message) {
        super(message);
    }
}
