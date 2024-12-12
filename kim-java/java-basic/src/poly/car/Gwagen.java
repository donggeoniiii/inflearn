package poly.car;

public class Gwagen implements Car {
	@Override
	public void startEngine() {
		System.out.println("G-Wagen 시동");
	}

	@Override
	public void offEngine() {
		System.out.println("G-Wagen 시동 끄기");
	}

	@Override
	public void pressAccelerator() {
		System.out.println("G-Wagen 가속하기");
	}
}
