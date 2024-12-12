package lang.object.poly;

public class ObjectPolyExample1 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();

        action(dog); // 멍멍
        action(car); // 자동차 이동
    }

    // 다형성의 기본: Object 클래스
    private static void action(Object obj) { // Dog, Car 인스턴스 둘다 받을 수 있음
        // obj.sound(); // compile error (Object는 sound()가 없음)
        // obj.move(); // compile error ((Object는 move()가 없음)

        // 객체에 맞는 다운캐스팅으로 처리(메서드 오버라이딩이 안되어 있어 어쩔 수 없음)
        if (obj instanceof Dog dog) {
            dog.sound();
        } else if (obj instanceof Car car) {
            car.move();
        }
    }
}
