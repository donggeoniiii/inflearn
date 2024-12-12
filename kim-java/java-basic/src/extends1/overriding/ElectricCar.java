package extends1.overriding;

public class ElectricCar extends Car {

	@Override // 어노테이션을 통해 부모의 메서드를 덮어쓴 것임을 표시(없어도 작동은 함)
	public void move() {
		System.out.println("전기차를 빠르게 이동합니다.");
	}

	public void charge() {
		System.out.println("충전합니다.");
	}
}
