package poly.car;

public class Driver {

    private Car car;

    // 차종 선택
    public void setCar(Car car) {
        System.out.println("자동차를 설정합니다: " + car);
        this.car = car;
    }

    // 운전하기
    public void drive() {
        System.out.println("자동차를 운전합니다.");
        car.startEngine();
        car.pressAccelerator();
        car.offEngine();
    }
}
