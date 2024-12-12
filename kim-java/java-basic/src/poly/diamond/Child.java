package poly.diamond;

// 인터페이스가 다중 구현이 허용되는 이유 
public class Child implements InterfaceA, InterfaceB {
    @Override
    public void methodA() {
        System.out.println("Child.methodA");
    }

    @Override
    public void methodB() {
        System.out.println("Child.methodB");
    }

    // 어차피 무조건 구현되어야 해서 무조건 자식 클래스의 구현된 메소드가 호출됨
    // 어느 부모 쪽 메소드를 선택할 것인가 하는 다이아몬드 문제 해결
    @Override
    public void methodCommon() {
        System.out.println("Child.methodCommon");
    }
}
