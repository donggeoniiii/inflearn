package nested.inner;

public class InnerOuterMain {

    public static void main(String[] args) {
        // 내부 클래스의 인스턴스를 생성하려면 먼저 바깥 클래스의 인스턴스부터 있어야 함
        // 그렇다고 진짜로 외부 클래스의 인스턴스 안에 내부 클래스 인스턴스가 생기는건 아니다!
        InnerOuter outer = new InnerOuter();
        // 내부 클래스는 참조할 인스턴스가 존재해야 한다(클래스 안엔 선언만 되어 있는 것)
        InnerOuter.Inner inner = outer.new Inner();
        inner.print();


        // 둘이 서로 다르다(당연함)
        InnerOuter.Inner inner1 = outer.new Inner();
        System.out.println("inner의 참조값: " + inner); // Inner@4e50df2e
        System.out.println("inner1의 참조값: " + inner1); // Inner@34a245ab

        System.out.println("innerClass = " + inner.getClass()); // nested.inner.InnerOuter
    }
}
