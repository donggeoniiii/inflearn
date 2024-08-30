package lang.object;

// 상속받는 부모 클래스가 없다 -> Object 클래스를 상속받고 있음(묵시적)
public class Parent { // extends Object
    public void parentMethod() {
        System.out.println("Parent.parentMethod");
    }
}
