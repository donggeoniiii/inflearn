package variable;

public class Var8 {
	public static void main(String[] args) {
		byte b = 127; // -128 ~ 127
		short s = 32767; // -32,768 ~ 32,767
		int i = 2147483647; // -2,147,483,648 ~ 2,147,483,647 (20억) -> 정수 리터럴의 기본

		// -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807 (920경)
		long l = 9223372036854775807L;

		float f = 10.0f;
		double d = 10.0; // 실수 리터럴의 기본
	}
}
