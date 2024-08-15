package method.ex;

public class MethodEx1 {
	public static void main(String[] args) {
		System.out.println("평균값: " + average(1, 2, 3));

		System.out.println("평균값: " + average(15, 25, 35));
	}

	public static double average(int num1, int num2, int num3) {
		int sum = num1 + num2 + num3;
		return sum / 3.0;
	}
}
