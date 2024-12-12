package nested.inner.ex2;

public class Car {
    private String model;
    private int chargeLevel;
    private Engine engine;

    public Car(String model, int chargeLevel) {
        this.model = model;
        this.chargeLevel = chargeLevel;
        // 내부 클래스의 인스턴스 생성, 내꺼니까 참조를 위한 this 생략
        this.engine = new Engine();
    }

    public void start() {
        engine.start();
        System.out.println(model + " 시작 완료");
    }

    // 내부에서만 사용되니까 private
    private class Engine {
        public void start() {
            System.out.println("충전 레벨 확인: " + chargeLevel);
            System.out.println(model + "의 엔진을 구동합니다.");
        }
    }

}
