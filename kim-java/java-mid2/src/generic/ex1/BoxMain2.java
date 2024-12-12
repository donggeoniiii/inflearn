package generic.ex1;

public class BoxMain2 {

    public static void main(String[] args) {
        // 다형성을 이용해 ObjectBox 안에 모든 값을 담을 수 있음
        ObjectBox integerBox = new ObjectBox();
        integerBox.set(10);
        Integer integer = (Integer) integerBox.get(); // 다운캐스팅
        System.out.println("integer = " + integer); // 10

        ObjectBox stringBox = new ObjectBox();
        stringBox.set("hello");
        String str = (String) stringBox.get(); // 다운 캐스팅
        System.out.println("str = " + str); // hello

        // 문제: 잘못된 타입이 전달되면?
        integerBox.set("문자100"); // String도 Object 변수에 담길 수 있음
        Integer result = (Integer) integerBox.get(); // exception: 타입이 안맞음
        System.out.println("result = " + result);

        // 입력값에 대한 타입 안전성이 보장되지 않음
    }

}