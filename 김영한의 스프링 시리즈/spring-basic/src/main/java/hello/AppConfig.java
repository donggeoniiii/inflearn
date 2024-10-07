package hello;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// DI 컨테이너: 외부에서 의존관계 주입 -> 서비스 코드는 추상화에만 의존, 관심사 분리됨
public class AppConfig {

	public MemberService memberService() {
		return new MemberServiceImpl(
			memberRepository()
		);
	}

	public OrderService orderService() {
		return new OrderServiceImpl(
			memberRepository(),
			discountPolicy()
		);
	}

	// 메서드 분리 -> 중복 제거 및 변경시 수정할 부분 최소화, 역할에 따른 구현 클래스가 잘 보임
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	public DiscountPolicy discountPolicy() {
		return new RateDiscountPolicy();
	}
}
