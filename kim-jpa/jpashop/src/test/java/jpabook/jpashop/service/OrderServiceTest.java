package jpabook.jpashop.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.exception.NotEnoughStockException;
import jpabook.jpashop.repository.OrderRepository;

@SpringBootTest
@Transactional
class OrderServiceTest {
	@Autowired
	OrderService orderService;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	EntityManager em;

	@Test
	public void 상품주문() {
		// given
		Member member = createMember();
		Book book = createBook("test", 10000, 10);

		// when
		int orderCount = 2;
		Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

		// then
		Order findOrder = orderRepository.findOne(orderId);
		assertThat(findOrder.getStatus()).isEqualTo(OrderStatus.ORDER);
		assertThat(findOrder.getOrderItems().size()).isEqualTo(1);
		assertThat(findOrder.getTotalPrice()).isEqualTo(10000 * orderCount);
		assertThat(book.getStock()).isEqualTo(8);
	}

	@Test
	public void 상품주문_재고부족() { // 엄밀하게는 도메인에 있는 재고관리 메서드를 단위 테스트 해보는게 제일 중요!
		// given
		Member member = createMember();
		Book book = createBook("test", 10000, 10);

		// when - throws
		int orderCount = 11;
		assertThrows(NotEnoughStockException.class, () -> orderService.order(member.getId(), book.getId(), orderCount));
	}

	@Test
	public void 주문취소() {
		// given
		Member member = createMember();
		Book book = createBook("test", 10000, 10);
		int orderCount = 2;
		Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

		// when
		Order findOrder = orderRepository.findOne(orderId);
		findOrder.cancel();

		// then
		assertThat(findOrder.getStatus()).isEqualTo(OrderStatus.CANCELED);
		assertThat(book.getStock()).isEqualTo(10);
	}

	private Member createMember() {
		Member member = new Member();
		member.setName("test");
		member.setAddress(new Address("서울", "테헤란로", "1"));
		em.persist(member);

		return member;
	}

	private Book createBook(String name, int price, int quantity) {
		Book book = new Book();
		book.setName(name);
		book.setPrice(price);
		book.setStock(quantity);
		em.persist(book);

		return book;
	}
}