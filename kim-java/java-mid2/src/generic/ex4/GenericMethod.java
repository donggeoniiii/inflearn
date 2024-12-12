package generic.ex4;

// 제네릭 메서드: 클래스 전체가 아니라 특정 메서드를 제네릭 타입으로 사용하고 싶을 때
// 클래스 이름 옆에 붙는 <>가 메서드 선언부 앞쪽에 붙는다고 생각하면 된다
public class GenericMethod {
    public static Object objMethod(Object obj) {
        System.out.println("object print: " + obj);
        return obj;
    }

    /*
        static 메서드는 메서드 호출 전에 타입이 결정되어야 함(클래스 단위 작동)
        따라서 타입 매개변수가 사용되지 못하므로
        static 메서드는 제네릭 메서드로 만들어야 타입 매개변수 사용 가능
     */
    public static <T> T genericMethod(T t) {
        System.out.println("generic print: " + t);
        return t;
    }

    /*
    compile error: 타입 매개변수 적용 안됨

    public static T genericMethod(T t) {
        System.out.println("generic print: " + t);
        return t;
    }
     */

    // Number: Integer, Double 등의 상위 클래스
    // 타입 매개변수 제한 가능
    public static <T extends Number> T numberMethod(T t) {
        System.out.println("bound print: " + t);
        return t;
    }
}