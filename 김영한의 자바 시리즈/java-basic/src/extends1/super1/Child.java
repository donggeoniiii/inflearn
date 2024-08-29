package extends1.super1;

public class Child extends Parent {

    public String value = "child";

    @Override
    public void hello() {
        System.out.println("Child.hello");
    }

    public void call() {
        // 자기 자신의 메소드를 가리킬 때 -> this(생략 가능)
        System.out.println("this value = " + this.value);
        hello();

        // 부모의 메소드를 가리키고 싶을 때 사용 -> super
        System.out.println("super value = " + super.value);
        super.hello();
    }
}
