package exception.ex1;

public class NetworkClientExceptionV1 extends Exception {

    private String errorCode;

    public NetworkClientExceptionV1(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
