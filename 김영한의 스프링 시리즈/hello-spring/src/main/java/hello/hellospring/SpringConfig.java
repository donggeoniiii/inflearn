package hello.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;

// 스프링 빈 직접 등록하기(컨트롤러는 안됨)
// 구현 클래스를 변경해야 하는 등 정형화되지 않은 상황에 좋음
@Configuration
public class SpringConfig {
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		// 나중에 DB가 결정되면 코드가 바뀔 부분(레포지터리 구현체가 바뀜)
		return new MemoryMemberRepository();
	}
}
