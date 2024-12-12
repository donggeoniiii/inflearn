package poly.ex.paycustom;

public abstract class PayUtil {
	// 결제수단 추가시 수정되어야 할 부분
	static Pay findPayOption(String option) {
		return switch (option) {
			case "kakao" -> new KakaoPay();
			case "naver" -> new NaverPay();
			case "toss" -> new TossPay();
			case "ali" -> new AliPay();
			case "new" -> new NewPay();
			default -> new NoPayOption();
		};
	}
}
