package operator;

public class Operator1 {
	public static void main(String[] args) {
		int a = 5;
		int b = 2;

		// 사칙연산
		int sum = a + b;
		System.out.println("a + b = " + sum);
		int diff = a - b;
		System.out.println("a - b = " + diff);
		int multi = a * b;
		System.out.println("a * b = " + multi);
		int div = a / b; // 정수형에서는 소수점 표현 안됨 -> 결과 2
		System.out.println("a / b = " + div);

		// 나머지 연산
		int mod = a % b;
		System.out.println("a % b = " + mod);

		// 0으로 나누기는 허용 안됨
		// int err = 5 % 0; // -> exception
	}
}
