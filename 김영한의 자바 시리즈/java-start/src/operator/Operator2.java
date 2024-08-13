package operator;

public class Operator2 {
	public static void main(String[] args) {
		// 문자열 간의 더하기
		String result1 = "hello" + " world";
		System.out.println(result1); // hello world

		String s1 = "string1";
		String s2 = "string2";
		String result2 = s1 + s2;
		System.out.println(result2); // string1string2

		// 문자열과 숫자 더하기
		String result3 = "a + b = " + 10; // 숫자가 문자열로 변경됨
		System.out.println(result3); // a + b = 10

		String s = "a + b = ";
		int a = 10;
		String result4 = s + a;
		System.out.println(result4); // a + b = 10

	}
}
