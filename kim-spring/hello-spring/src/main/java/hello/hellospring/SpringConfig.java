package hello.hellospring;

import org.springframework.context.annotation.Bean;

import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;

// 스프링 빈 직접 등록하기(컨트롤러는 안됨)
// 구현 클래스를 변경해야 하는 등 정형화되지 않은 상황에 좋음
// @Configuration
public class SpringConfig {
	// 데이터 소스 의존성 주입(properties 정보 바탕으로 스프링이 연결)
	// private final DataSource dataSource;

	// 스프링이 자동으로 만들어줌, DB 정보도 들고 있다
	private final EntityManager entityManager;

	// public SpringConfig(DataSource dataSource) {
	// 	this.dataSource = dataSource;
	// }

	public SpringConfig(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		// DB가 변경되면 코드가 바뀔 부분(레포지터리 구현체가 바뀜)
		// return new MemoryMemberRepository();
		// return new JdbcMemberRepository(dataSource);
		// return new JdbcTemplateMemberRepository(dataSource);
		return new JpaMemberRepository(entityManager);
	}
}
