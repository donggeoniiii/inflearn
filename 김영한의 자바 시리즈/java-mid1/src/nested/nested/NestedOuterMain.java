package nested.nested;

public class NestedOuterMain {
    public static void main(String[] args) {
        NestedOuter outer = new NestedOuter();
        NestedOuter.Nested nested = new NestedOuter.Nested();
        nested.print(); // nested 자체가 외부클래스 내부에 있음 -> private 변수 접근 가능

        System.out.println("nestedClass = " + nested.getClass()); // nested.nested.NestedOuter
    }
}
