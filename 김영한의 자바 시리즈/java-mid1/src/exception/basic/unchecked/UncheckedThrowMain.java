package exception.basic.unchecked;

public class UncheckedThrowMain {
    // main까지 예외를 던지면 예외 정보와 스택 트레이스(예외가 던져진 경로)를 출력하고 종료
    public static void main(String[] args) {
        Service service = new Service();
        service.callThrow();
        System.out.println("정상 종료");
    }
}
