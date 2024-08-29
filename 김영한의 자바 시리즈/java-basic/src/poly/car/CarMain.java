package poly.car;

public class CarMain {
    public static void main(String[] args) {
        Driver driver = new Driver();

        // 차량 선택(GV70)
        Car gv70 = new GV70();
        driver.setCar(gv70);
        driver.drive();

        // 차량 변경(GWagen)
        Car gwagen = new Gwagen();
        driver.setCar(gwagen);
        driver.drive();
    }
}
