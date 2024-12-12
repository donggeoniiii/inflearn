package nested.inner.ex1;

// Car에서만 사용
public class Engine {

    private Car car;

    public Engine(Car car) {
        this.car = car;
    }

    // 메서드 내용도 car의 멤버 변수를 이용
    public void start() {
        System.out.println("충전 레벨 확인: " + car.getChargeLevel());
        System.out.println(car.getModel() + "의 엔진을 구동합니다.");
    }
}
