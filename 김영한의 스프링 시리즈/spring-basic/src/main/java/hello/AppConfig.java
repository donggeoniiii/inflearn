package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// DI 컨테이너: 외부에서 의존관계 주입 -> 서비스 코드는 추상화에만 의존, 관심사 분리됨
@Configuration // 애플리케이션 설정 정보를 저장하는 파일
public class AppConfig {

	@Bean // 해당 메서드가 반환하는 객체가 스프링 빈으로 스프링 컨테이너에 등록될 예정
	public MemberService memberService() {
		return new MemberServiceImpl(
			memberRepository()
		);
	}

	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(
			memberRepository(),
			discountPolicy()
		);
	}

	// 메서드 분리 -> 중복 제거 및 변경시 수정할 부분 최소화, 역할에 따른 구현 클래스가 잘 보임
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	@Bean
	public DiscountPolicy discountPolicy() {
		return new RateDiscountPolicy();
	}

	// 이런 수동 빈 등록은 공통 관심사로 개발되는 기술 지원 로직들에 적합하다.
	// 수동 빈 등록은 의존 관계를 명확하게 드러내는 것이 장점임을 명심하자!
	// 의존관계가 복잡한 비즈니스 로직은 컴포넌트(스캔) 어노테이션을 활용한 자동 빈 등록을 애용하자
}
