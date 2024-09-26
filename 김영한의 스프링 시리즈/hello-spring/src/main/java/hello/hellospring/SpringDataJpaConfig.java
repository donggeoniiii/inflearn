package hello.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;

@Configuration
public class SpringDataJpaConfig {

	// 스프링이 알아서 JpaRepository를 상속하는 레포지토리 인터페이스를 찾고, 구현체를 생성해 Bean으로 등록
	private final MemberRepository memberRepository;

	public SpringDataJpaConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
}
