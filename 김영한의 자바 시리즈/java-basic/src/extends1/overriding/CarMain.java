package extends1.overriding;

public class CarMain {

    public static void main(String[] args) {
        GasCar gasCar = new GasCar();
        ElectricCar electricCar = new ElectricCar();

        // GasCar 타입 -> 오버라이드 x, 상위 메서드에서 찾아서 사용
        gasCar.move(); // 차를 이동합니다.

        // ElectricCar 타입 -> 오버라이드 된 메서드 먼저 사용
        electricCar.move(); // 전기차를 빠르게 이동합니다.
    }
}
