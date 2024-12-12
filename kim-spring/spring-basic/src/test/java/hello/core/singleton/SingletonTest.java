package hello.core.singleton;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.AppConfig;
import hello.core.member.MemberService;

public class SingletonTest {

	@Test
	@DisplayName("순수 java DI 컨테이너")
	public void pureContainer() {
		AppConfig appConfig = new AppConfig();

		MemberService memberService = appConfig.memberService();

		MemberService memberService2 = appConfig.memberService();

		// 메서드를 호출할 때마다 새 인스턴스 반환 -> 메모리 낭비
		assertThat(memberService).isNotSameAs(memberService2);
	}

	@Test
	@DisplayName("싱글톤 패턴 적용")
	public void singletonServiceTest() {
		SingletonService singletonService = SingletonService.getInstance();
		SingletonService singletonService2 = SingletonService.getInstance();

		assertThat(singletonService).isSameAs(singletonService2);
	}

	@Test
	@DisplayName("스프링 컨테이너(싱글톤)")
	public void springContainer() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		MemberService memberService = ac.getBean(MemberService.class);
		MemberService memberService2 = ac.getBean(MemberService.class);

		// 스프링 빈을 관리하는 레지스트리는 싱글톤!
		assertThat(memberService).isSameAs(memberService2);
	}
}
