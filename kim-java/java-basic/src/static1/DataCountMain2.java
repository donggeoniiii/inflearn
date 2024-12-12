package static1;

// 변수를 공유하자!
public class DataCountMain2 {
	public static void main(String[] args) {
		Counter counter = new Counter(); // 공용 카운터
		Data2 data1 = new Data2("A", counter);
		System.out.println("A count = " + counter.count); // 1

		Data2 data2 = new Data2("B", counter);
		System.out.println("B count = " + counter.count); // 2

		Data2 data3 = new Data2("C", counter);
		System.out.println("C count = " + counter.count); // 3

		// 단점: Data 말고 다른 클래스도 사용해야 됨, 생성자도 깔끔하지 않음
	}
}
