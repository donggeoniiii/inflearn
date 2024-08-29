package final1;

public class FinalRefMain {
    public static void main(String[] args) {
        // 참조형 변수 final 선언: 한 인스턴스가 할당되면 다른 인스턴스 참조 불가
        final Data data = new Data();
        // data = new Data(); // compile error

        // final 참조 대상의 값은 final이 아니라면 변경 가능
        data.value = 10;
        System.out.println(data.value);
        data.value = 20;
        System.out.println(data.value);
    }
}
