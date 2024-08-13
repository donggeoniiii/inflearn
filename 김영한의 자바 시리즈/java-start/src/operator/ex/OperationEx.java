package operator.ex;

public class OperationEx {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;

		int sum = num1 + num2 + num3;
		int average = sum / 3; // 소수점 이하 버림
		System.out.println(sum); // 60
		System.out.println(average); // 20

	}
}
