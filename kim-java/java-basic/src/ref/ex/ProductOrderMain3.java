package ref.ex;

import java.util.Scanner;

public class ProductOrderMain3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("입력할 주문의 개수를 입력하세요: ");
		int orderCnt = input.nextInt();
		input.nextLine(); // 개행문자 제거

		// 주문별 상품명, 가격, 수량 정보 입력
		ProductOrder[] orders = new ProductOrder[orderCnt];
		for (int i = 1; i <= orders.length; i++) {
			System.out.println(i + "번째 주문 정보를 입력하세요.");
			System.out.print("상품명: ");
			String productName = input.nextLine();
			System.out.print("가격: ");
			int price = input.nextInt();
			System.out.print("수량: ");
			int quantity = input.nextInt();
			ProductOrder order = createOrder(productName, price, quantity);
			orders[i-1] = order;
			
			input.nextLine(); // 개행문자 제거
		}

		// 등록한 상품과 총 결제금액 출력
		printOrders(orders);

		int totalAmount = getTotalAmount(orders);
		System.out.println("총 결제 금액: " + totalAmount);
	} // main()

	private static ProductOrder createOrder(String productName, int price, int quantity) {
		ProductOrder order = new ProductOrder();
		order.productName = productName;
		order.price = price;
		order.quantity = quantity;
		return order;
	} // createOrder()

	private static void printOrders(ProductOrder[] productOrders) {
		for (ProductOrder order : productOrders) {
			System.out.println("상품명: " + order.productName + ", 가격: " + order.price + ", 수량: " + order.quantity);
		}
	} // printOrders()

	private static int getTotalAmount(ProductOrder[] productOrders) {
		int totalAmount = 0;
		for (ProductOrder order : productOrders) {
			totalAmount += order.price * order.quantity;
		}
		return totalAmount;
	} // getTotalAmount()
}
