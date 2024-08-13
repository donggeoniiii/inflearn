package operator;

public class OperatorComp2 {
	public static void main(String[] args) {
		// 문자열은 .equals() 메소드 사용
		boolean result1 = "안녕".equals("안녕");
		System.out.println("result1 = " + result1); // true

		String s1 = "문자열1";
		String s2 = "문자열2";
		boolean result2 = s1.equals("문자열1");
		System.out.println("result2 = " + result2); // true
		
		boolean result3 = s1.equals(s2);
		System.out.println("result3 = " + result3); // false
	}
}
