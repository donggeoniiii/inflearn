package jpabook.jpashop.domain;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter	@Setter
public class Order {

	@Id @GeneratedValue
	@Column(name = "order_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	// cascade 옵션: 해당 객체가 영속화 될 때 연결된 얘네도 같이 영속화
	// 수정, 삭제 등 동기화 가능(옵션에 따라)
	@OneToMany(mappedBy = "order", cascade = ALL)
	private List<OrderItem> orderItems = new ArrayList<>();

	@OneToOne(fetch = LAZY, cascade = ALL)
	@JoinColumn(name = "delivery_id")
	private Delivery delivery;

	// 스프링부트가 알아서 camelCase -> snake_case 바꿔줌
	// 이게 싫다면 hibernate 패키지에서 SpringPhysicalNamingStrategy 를 바꿔주자
	private LocalDateTime orderTime;

	@Enumerated(EnumType.STRING)
	private OrderStatus status; // [ORDERED, CANCELED]

	// == 연관관계 메서드 == //
	public void setMember(Member member) {
		this.member = member;
		member.getOrders().add(this); // 양방향으로 한번에 수정
	}

	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
		delivery.setOrder(this);
	}

	// == 생성 메서드 == //
	// 주문은 중심이 되는 기능으로 다른 엔티티와 연관관계가 많아 이런 메서드가 필요
	public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
		Order order = new Order();
		order.setMember(member);
		order.setDelivery(delivery);
		for (OrderItem orderItem : orderItems) {
			order.addOrderItem(orderItem);
		}
		order.setStatus(OrderStatus.ORDER);
		order.setOrderTime(LocalDateTime.now());
		return order;
	}

	// == 비즈니스 로직 == //
	/**
	 *  주문 취소
	 */
	public void cancel() {
		if (delivery.getStatus() == DeliveryStatus.COMP) {
			throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
		}

		this.setStatus(OrderStatus.CANCELED);
		for (OrderItem orderItem : orderItems) {
			orderItem.cancel();
		}
	}

	// == 조회 로직 == //
	/**
	 * 전체 주문 가격 조회
	 */
	public int getTotalPrice() {
		return orderItems.stream()
			.mapToInt(OrderItem::getTotalPrice)
			.sum();
	}
}
