package exception.basic.checked;

/**
 * Exception을 상속받은 예외는 체크 예외다.
 */
public class MyCheckedException extends Exception {
    public MyCheckedException(String message) {
        super(message);
    }
}
