package class1.ex;

public class ProductOrderMain {
	public static void main(String[] args) {
		// 여러 상품의 주문 정보를 담는 배열
		ProductOrder[] productOrders;

		// 상품의 주문 정보를 ProductOrder 타입 변수로 받아 저장
		ProductOrder productOrder1 = new ProductOrder();
		productOrder1.productName = "두부";
		productOrder1.price = 2000;
		productOrder1.quantity = 2;

		ProductOrder productOrder2 = new ProductOrder();
		productOrder2.productName = "김치";
		productOrder2.price = 5000;
		productOrder2.quantity = 1;

		ProductOrder productOrder3 = new ProductOrder();
		productOrder3.productName = "콜라";
		productOrder3.price = 1500;
		productOrder3.quantity = 2;

		productOrders = new ProductOrder[] {productOrder1, productOrder2, productOrder3};

		// 상품 주문 정보와 최종 금액 출력
		int totalPrice = 0;
		for (ProductOrder order : productOrders) {
			System.out.println("상품명: " + order.productName + ", 가격: " + order.price + ", 수량: " + order.quantity);
			totalPrice += order.price * order.quantity;
		}
		System.out.println("총 결제 금액: " + totalPrice);
	}
}
