package generic.ex1;

public class RawTypeMain {

    public static void main(String[] args) {
        // 원시 타입: 타입 매개변수가 Object(비권장)
        // 하위 버전 코드를 위한 것
        GenericBox integerBox = new GenericBox();

        // 권장
        // GenericBox<Object> integerBox = new GenericBox<>();

        integerBox.set(10);
        Integer result = (Integer) integerBox.get();
        System.out.println("result = " + result);
    }
}