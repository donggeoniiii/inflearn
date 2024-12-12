package hello.core.order;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

class OrderServiceTest {
	MemberService memberService;
	OrderService orderService;

	@BeforeEach
	void setUp() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
		orderService = appConfig.orderService();
	}

	@Test
	void createOrder() {
		// given
		Long memberId = 1L;
		Member member = new Member(memberId, "동건", Grade.VIP);
		memberService.join(member);

		// when
		Order order = orderService.createOrder(memberId, "RTX 3080Ti", 490_000);

		// then
		assertThat(order.getDiscountPrice()).isEqualTo(49000);
	}
}