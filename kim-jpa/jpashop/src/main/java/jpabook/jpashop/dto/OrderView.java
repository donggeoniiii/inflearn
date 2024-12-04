package jpabook.jpashop.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderView {
	private Long id;

	private Member member;

	private List<OrderItem> orderItems = new ArrayList<>();

	private OrderStatus status; // [ORDERED, CANCELED]

	private LocalDateTime orderTime;
}
