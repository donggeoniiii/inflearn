package poly.basic;

public class CastingMain5 {
    public static void main(String[] args) {
        Parent parent1 = new Parent();
        System.out.println("parent1 호출");
        call(parent1);

        Parent parent2 = new Child();
        System.out.println("parent2 호출");
        call(parent2);
    }

    private static void call(Parent parent) {
        parent.parentMethod();
        // java 16부터 instanceof 구문에서 변수 선언이 가능
        if (parent instanceof Child child) { // Child 변수 선언
            System.out.println("Child 인스턴스 맞음");
            child.childMethod(); // 바로 사용 가능(조건문이 참일 때부터 다운캐스팅은 가능했음)
        }
    }

}
