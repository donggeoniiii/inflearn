package poly.ex.paycustom;

public class NewPay implements Pay{
	@Override
	public boolean pay(int amount) {
		System.out.println("새로운 페이 시스템과 연결합니다.");
		System.out.println(amount + "원 결제를 시도합니다.");
		return true;
	}
}
