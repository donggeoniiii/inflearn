package lang.object;

// 어떤 클래스의 자식 클래스 역시 Object 클래스 하위의 클래스임
public class Child extends Parent {
    public void childMethod() {
        System.out.println("Child.childMethod");
    }
}
