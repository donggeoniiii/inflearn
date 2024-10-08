package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {
	public static void main(String[] args) {
		// AppConfig config = new AppConfig();
		// MemberService memberService = config.memberService();
		// OrderService orderService = config.orderService();

		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		OrderService orderService = ac.getBean("orderService", OrderService.class);

		Long memberId = 1L;
		Member member = new Member(memberId, "동건", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "RTX 4080Ti", 1_000_000);
		System.out.println(order);
	}
}
