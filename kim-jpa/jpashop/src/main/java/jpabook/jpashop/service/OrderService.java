package jpabook.jpashop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Delivery;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.dto.OrderView;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

	private final MemberRepository memberRepository;
	private final OrderRepository orderRepository;
	private final ItemRepository itemRepository;

	// 주문
	@Transactional
	public Long order(Long memberId, Long itemId, int count) {
		Member member = memberRepository.findOne(memberId);
		Item item = itemRepository.findOne(itemId);

		// 배송정보는 따로 입력으로 받아오는게 맞으나 실습이니까 간단하게
		Delivery delivery = new Delivery();
		delivery.setAddress(member.getAddress());

		OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

		Order order = Order.createOrder(member, delivery, orderItem);

		// cascade all 옵션으로 위에서 생성한 orderItem, delivery 정보도 한번에 영속화
		// cascade 옵션은 참조하는 케이스가 한정적인 경우에만 잘 생각해서 쓰자
		orderRepository.save(order);

		return order.getId();
	}

	// 취소
	@Transactional
	public void cancel(Long orderId) {
		Order order = orderRepository.findOne(orderId);

		order.cancel(); // 객체에 있는 비즈니스 메서드를 따라 알아서 처리됨

		// 업데이트는 JPA가 알아서 한다(더티 체킹: 변경사항 체크)
	}

	// 검색
	public List<OrderView> findOrders(OrderSearch search) {
		return orderRepository.findAllByCriteria(search).stream()
			.map(Order::toView)
			.collect(Collectors.toList());
	}
}
