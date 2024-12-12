package generic.ex1;

public class BoxMain1 {

    public static void main(String[] args) {
        IntegerBox integerBox = new IntegerBox();
        integerBox.set(10);
        Integer integer = integerBox.get();
        System.out.println("integer = " + integer); // 10

        StringBox stringBox = new StringBox();
        stringBox.set("hello");
        String str = stringBox.get();
        System.out.println("str = " + str); // hello

        // 문제: double, long 등을 사용해야 되면 그때마다 클래스를 생성해야 하나?
    }

}