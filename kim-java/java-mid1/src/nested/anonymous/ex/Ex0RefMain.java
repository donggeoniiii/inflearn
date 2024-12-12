package nested.anonymous.ex;

public class Ex0RefMain {
	// 변하는 부분은 메서드 밖에서, 변하지 않는 부분은 메서드 안에서
	public static void hello(String name) {
		System.out.println("프로그램 시작");
		System.out.println("Hello " + name);
		System.out.println("프로그램 종료");
	}

	public static void main(String[] args) {
		hello("Java");
		hello("Spring");
	}
}
