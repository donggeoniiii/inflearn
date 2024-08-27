package ref;

public class NullMain1 {
    public static void main(String[] args) {
        Data data = null; // 초기화 안함, 담고 있는 참조값 없음
        System.out.println("1. data = " + data); // null
        data = new Data();
        System.out.println("2. data = " + data); // 참조값
        data = null; // 변수가 담고 있는 참조값을 삭제
        System.out.println("3. data = " + data); // null
    }
}
