package method.ex;

public class MethodEx3 {
	public static void main(String[] args) {
		int balance = 10000;

		// 메소드 추출: 재사용되지 않는 코드라도 메소드를 분리하면 코드의 흐름이 더 잘 보인다
		balance = deposit(balance, 1000);
		balance = withdraw(balance, 2000);

		System.out.println("최종 잔액: " + balance + "원");
	}

	public static int deposit(int balance, int amount) {
		balance += amount;
		System.out.println(amount + "원을 입금하였습니다. 현재 잔액: " + balance + "원");
		return balance;
	}

	public static int withdraw(int balance, int amount) {
		balance -= amount;
		System.out.println(amount + "원을 출금하였습니다. 현재 잔액: " + balance + "원");
		return balance;
	}
}
