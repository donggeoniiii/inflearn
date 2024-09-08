package collection.array;

public class MyArrayListV4Main {
	public static void main(String[] args) {
		MyArrayListV4<Integer> numberList = new MyArrayListV4<>();

		// 숫자만 입력 하기를 기대
		numberList.add(1);
		numberList.add(2);
		// numberList.add("3"); // 잘못된 입력하면 안받음
		System.out.println(numberList); // [1, 2]

		// 다운 캐스팅 필요 없음
		int num1 = numberList.get(0);
		int num2 = numberList.get(1);
	}
}
