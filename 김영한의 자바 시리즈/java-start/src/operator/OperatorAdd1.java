package operator;

public class OperatorAdd1 {
	public static void main(String[] args) {
		int a = 0;

		a = a + 1;
		System.out.println("a = " + a); // 1

		a = 1; // 증가 안됨!
		System.out.println("a = " + a); // 1

		a++;
		System.out.println("a = " + a); // 2

		a--;
		System.out.println("a = " + a); // 1
	}
}
