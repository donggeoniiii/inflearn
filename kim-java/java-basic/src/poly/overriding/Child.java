package poly.overriding;

public class Child extends Parent {

    public String value = "child";

    // 오버라이딩된 메서드는 항상 우선권을 가진다!!
    @Override
    public void method() {
        System.out.println("Child.method");
    }
}
