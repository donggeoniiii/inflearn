package nested.anonymous.ex;

import java.util.Random;

public class Ex1RefMainV4 {

	public static void hello(Process process) {
		System.out.println("프로그램 시작");

		// 코드 조각 시작
		process.run();
		// 코드 조각 종료

		System.out.println("프로그램 종료");
	}

	public static void main(String[] args) {
		// 람다: 클래스나 인스턴스 없이 코드 블럭만 던지고 싶어!
		Process dice = () -> {
			int randomValue = new Random().nextInt(6) + 1;
			System.out.println("주사위 = " + randomValue);
		};

		Process sum = () -> {
			for (int i = 0; i < 3; i++) {
				System.out.println("i = " + i);
			}
		};

		hello(dice);
		hello(sum);
	}
}
