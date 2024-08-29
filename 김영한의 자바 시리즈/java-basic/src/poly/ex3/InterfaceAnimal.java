package poly.ex3;

// 순수 추상 클래스 + a == 인터페이스
public interface InterfaceAnimal {
	// 모든 메소드는 public abstract, 생략 가능하며 생략이 권장됨
	void sound();
	void move();

	// 인터페이스의 멤버변수 static final, 즉 상수다(생략되어 있음)
	int TEST = 1;
}
