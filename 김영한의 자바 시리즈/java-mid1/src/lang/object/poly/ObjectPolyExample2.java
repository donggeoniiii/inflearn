package lang.object.poly;

public class ObjectPolyExample2 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();

        // Object는 추상 클래스가 아니다! 따라서 인스턴스도 만들 수 있다
        Object object = new Object();

        // 최상위 클래스이므로 배열 안에 여러 가지 객체를 담을 수 있음
        Object[] objects = {dog, car, object};

        size(objects); // 전달된 객체의 수는: 3
    }

    private static void size(Object[] objects) { // 온갖 객체가 들어간 배열이 다 사용 가능함(유연함)
        System.out.println("전달된 객체의 수는: " + objects.length);
    }

}
