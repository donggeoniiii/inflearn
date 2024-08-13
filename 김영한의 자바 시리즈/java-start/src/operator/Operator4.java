package operator;

public class Operator4 {
	public static void main(String[] args) {
		int sum3 = 2 * 2 + 3 * 3; // (2 * 2) + (3 * 3)
		System.out.println(sum3); // 13

		// 애매하면 괄호를 쓰는게 바람직하다(명확함이 생명)
		int sum4 = (2 * 2) + (3 * 3); // 위와 동일, 더 잘 읽힘
		System.out.println(sum4); // 13
	}
}
