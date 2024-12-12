package operator;

public class OperatorLogical1 {
	public static void main(String[] args) {
		// AND 연산: 둘 다 참이어야 true 반환
		System.out.println(true && true); // true
		System.out.println(false && false); // false
		System.out.println(true && false); // false

		// OR 연산: 둘 중 하나 참이면 true 변환
		System.out.println(true || true); // true
		System.out.println(false || false); // false
		System.out.println(true || false); // true

		// ! 연산: negative, 해당 결과의 반대값 반환
		System.out.println(!true); // false
		System.out.println(!false); // true

	}
}
