package nested.anonymous.ex;

import java.util.Random;

public class Ex1RefMainV3 {
	public static void hello(Process process) {
		System.out.println("프로그램 시작");

		// 코드 조각 시작
		process.run();
		// 코드 조각 종료

		System.out.println("프로그램 종료");
	}

	public static void main(String[] args) {
		// 한번씩만 쓰니까 익명 클래스 사용
		Process dice = new Process() {
			@Override
			public void run() {
				int randomValue = new Random().nextInt(6) + 1;
				System.out.println("주사위 = " + randomValue);
			}
		};

		Process sum = new Process() {
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.println("i = " + i);
				}
			}
		};

		hello(dice);
		hello(sum);
	}

}
