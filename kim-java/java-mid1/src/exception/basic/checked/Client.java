package exception.basic.checked;

public class Client {
    public void call() throws MyCheckedException {
        // 문제 상황이 발생하면 throw 키워드로 예외를 던짐(여기서 처리하지 않는다는 의미)
        throw new MyCheckedException("ex");
    }
}
