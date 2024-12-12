package collection.map.test.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<Product, Integer> products = new HashMap<>();

	public void add(Product product, int quantity) {
		products.put(product, products.getOrDefault(product, 0) + quantity);
	}

	public void printAll() {
		System.out.println("==모든 상품 출력==");
		for (Map.Entry<Product, Integer> entry : products.entrySet()) {
			System.out.println("상품: " + entry.getKey() + " 수량: " + entry.getValue());
		}
	}

	public void minus(Product product, int minusQuantity) {
		int quantity = products.get(product);

		if (quantity - minusQuantity <= 0) {
			products.remove(product);
			return;
		}

		products.put(product, quantity - minusQuantity);
	}
}
