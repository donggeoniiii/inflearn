package poly.car;

public class GV70 implements Car {

	@Override
	public void startEngine() {
		System.out.println("GV70 시동");
	}

	@Override
	public void offEngine() {
		System.out.println("GV70 시동 끄기");
	}

	@Override
	public void pressAccelerator() {
		System.out.println("GV70 가속하기");
	}
}
