package operator;

public class Operator3 {
	public static void main(String[] args) {
		// 우선순위는 외우기보단 필요할 때 찾아쓰자(상식적인건 아니까)
		int sum1 = 1 + 2 * 3; // 1 + (2 * 3) 과 같음
		System.out.println(sum1); // 7

		int sum2 = (1 + 2) * 3; // 보이는 그대로
		System.out.println(sum2); // 9
	}
}
