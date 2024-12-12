package poly.ex.paycustom;

public class AliPay implements Pay{
	@Override
	public boolean pay(int amount) {
		System.out.println("알리페이 시스템과 연결합니다.");
		System.out.println(amount + "원 결제를 시도합니다.");
		return true;
	}
}
