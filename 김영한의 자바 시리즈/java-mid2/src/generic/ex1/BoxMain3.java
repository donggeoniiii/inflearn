package generic.ex1;

public class BoxMain3 {

    public static void main(String[] args) {
        // 생성 시점에 타입 매개변수 T의 타입 결정
        GenericBox<Integer> integerBox = new GenericBox<Integer>();
        integerBox.set(10);
        // integerBox.set("문자100"); // compile error: 타입 안맞음 표시
        Integer integer = integerBox.get(); // 캐스팅 필요 없음
        System.out.println("integer = " + integer);

        // 원하는 모든 타입 사용 가능
        GenericBox<String> stringBox = new GenericBox<String>();
        stringBox.set("hello");
        String str = stringBox.get();
        System.out.println("str = " + str);

        // 타입 추론
        GenericBox<Integer> integerBox2 = new GenericBox<>(); // 여기엔 타입 안 적어도 됨
    }
}