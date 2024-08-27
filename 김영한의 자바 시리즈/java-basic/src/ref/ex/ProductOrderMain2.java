package ref.ex;

public class ProductOrderMain2 {
	public static void main(String[] args) {
		// 여러 상품의 주문 정보를 담는 배열 생성
		ProductOrder[] productOrders;

		// createOrder()를 여러번 사용해서 상품 주문 정보들을 생성하고 배열에 저장
		ProductOrder productOrder1 = createOrder("두부", 2000, 2);
		ProductOrder productOrder2 = createOrder("김치", 5000, 1);
		ProductOrder productOrder3 = createOrder("콜라", 1500, 2);

		productOrders = new ProductOrder[] {productOrder1, productOrder2, productOrder3};

		// printOrders()를 사용해서 상품 주문 정보 출력
		printOrders(productOrders);

		// getTotalAmount()를 사용해서 총 결제 금액 계산
		int totalAmount = getTotalAmount(productOrders);

		// 총 결제 금액 출력
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