package hello.core.Order;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

class OrderServiceTest {
	private final MemberService memberService = new MemberServiceImpl();
	private final OrderService orderService = new OrderServiceImpl();

	@Test
	void createOrder() {
		// given
		Long memberId = 1L;
		Member member = new Member(memberId, "동건", Grade.VIP);
		memberService.join(member);

		// when
		Order order = orderService.createOrder(memberId, "RTX 3080Ti", 490_000);

		// then
		assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
}