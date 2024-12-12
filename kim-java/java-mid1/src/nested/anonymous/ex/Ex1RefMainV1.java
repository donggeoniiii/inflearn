package nested.anonymous.ex;

import java.util.Random;

public class Ex1RefMainV1 {
	static class Dice implements Process {

		// 코드 조각은 인스턴스로 전달하고, 그 안에 메서드로 전달하면 편하다
		@Override
		public void run() {
			int randomValue = new Random().nextInt(6) + 1;
			System.out.println("주사위 = " + randomValue);
		}
	}

	static class Sum implements Process {
		@Override
		public void run() {
			for (int i = 0; i < 3; i++) {
				System.out.println("i = " + i);
			}
		}
	}

	public static void hello(Process process) {
		System.out.println("프로그램 시작");

		// 코드 조각 시작
		process.run();
		// 코드 조각 종료

		System.out.println("프로그램 종료");
	}

	public static void main(String[] args) {
		Dice dice = new Dice();
		Sum sum = new Sum();
		hello(dice);
		hello(sum);
	}

}
