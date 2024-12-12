package poly.ex.paycustom;

public class PayService {
    public void processPay(String option, int amount) {
        boolean isSuccess;
        System.out.println("결제를 시작합니다: option = " + option + ", amount = " + amount);

        Pay selectedPay = PayUtil.findPayOption(option);
        isSuccess = selectedPay.pay(amount);

        if (isSuccess) {
            System.out.println("결제가 성공했습니다.");
        } else {
            System.out.println("결제가 실패했습니다.");
        }
    }
}