package final1;

public class FinalLocalMain {
	public static void main(String[] args) {
		// final 변수: 한번 값이 들어가면 다른 값 할당 안됨
		final int data1;
		data1 = 10;
		// data1 = 20; // compile error

		final int data2 = 10;
		changeValue(10); // 이렇게 수정하려고 해도 안됨
	}

	static void changeValue(final int parameter) {
		// parameter = 20; // compile error
	}
}
