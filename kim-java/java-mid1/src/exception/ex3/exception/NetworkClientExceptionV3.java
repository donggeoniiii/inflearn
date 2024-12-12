package exception.ex3.exception;

// 처리할 수 없는 예외들에 대해 처리하기 위해 RunTimeException 상속
public class NetworkClientExceptionV3 extends RuntimeException {
    public NetworkClientExceptionV3(String message) {
        super(message);
    }
}
