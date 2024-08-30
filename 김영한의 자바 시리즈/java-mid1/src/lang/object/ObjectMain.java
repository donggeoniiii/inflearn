package lang.object;

public class ObjectMain {
    public static void main(String[] args) {
        Child child = new Child();
        child.childMethod(); // Child.childMethod
        child.parentMethod(); // Parent.parentMethod(상속받음)

        // toString(): Object 클래스의 메서드
        // 그냥 쓸 수 있다는 것부터 상속 받은 상태라는 뜻
        String string = child.toString();
        System.out.println(string); // lang.object.Child@참조값

    }
}
