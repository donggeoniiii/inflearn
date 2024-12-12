package poly.basic;

public class CastingMain4 {
    public static void main(String[] args) {
        Parent parent1 = new Parent();
        System.out.println("parent1 호출");
        call(parent1); // parent 메소드 호출

        Parent parent2 = new Child();
        System.out.println("parent2 호출");
        call(parent2); // parent, child 메소드 모두 호출
    }

    private static void call(Parent parent) {
        parent.parentMethod();

        // A instanceof B가 참 == A가 클래스 B의 인스턴스를 참조함
        // 클래스 B에 A의 인스턴스가 대입될 수 있으면 참이다
        if (parent instanceof Child) {
            System.out.println("Child 인스턴스 맞음");
            Child child = (Child) parent;
            child.childMethod();
        }
    }

}
