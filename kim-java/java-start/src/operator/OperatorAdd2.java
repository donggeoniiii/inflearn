package operator;

public class OperatorAdd2 {
	public static void main(String[] args) {
		int a = 0;

		int b = ++a; // 대입 전에 증가됨
		/*
		같은 코드:
		a = a + 1;
		int b = a;
		 */
		System.out.println("b = " + b); // 1

		int c = a++; // 대입 후에 증가됨
		/*
		같은 코드:
		int c = a;
		a = a + 1;
		 */
		System.out.println("c = " + c); // 1

		System.out.println("a = " + a); // 2
	}
}
