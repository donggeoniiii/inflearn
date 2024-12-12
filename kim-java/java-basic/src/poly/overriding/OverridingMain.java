package poly.overriding;

public class OverridingMain {
    public static void main(String[] args) {
        // 자식 변수가 자식 인스턴스 참조
        Child child = new Child();
        System.out.println("Child -> Child");
        System.out.println("value = " + child.value); // value = child
        child.method(); // Child.method

        // 부모 변수가 부모 인스턴스 참조
        Parent parent = new Parent();
        System.out.println("Parent -> Parent");
        System.out.println("value = " + parent.value); // value = parent
        parent.method(); // Parent.method

        // 부모 변수가 자식 인스턴스 참조(다형적 참조)
        Parent poly = new Child();
        System.out.println("Parent -> Child");
        // 변수는 원 클래스 그대로, 메서드는 재정의된 자식 메서드로
        System.out.println("value = " + poly.value); // value = parent
        poly.method(); // Child.method

        /*
            즉, 다형적 참조를 하면
            원 클래스의 멤버 변수를 가지고
            자녀 클래스의 재정의된 메서드를 사용하게 할 수 있다!
         */
    }
}
