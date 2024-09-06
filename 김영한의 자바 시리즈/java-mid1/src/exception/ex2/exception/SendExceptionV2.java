package exception.ex2.exception;

// 전송 실패 예외, 네트워크 예외 클래스를 상속받음(얘도 객체니까 가능)
public class SendExceptionV2 extends NetworkClientExceptionV2 {

    private final String sendData;

    public SendExceptionV2(String sendData, String message) {
        super(message);
        this.sendData = sendData;
    }

    public String getSendData() {
        return sendData;
    }
}
