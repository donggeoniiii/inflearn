package hello.core.beanfind;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class ApplicationContextBasicFindTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("빈 이름으로 조회하기")
	void findBeanByName() {
		MemberService memberService = ac.getBean("memberService", MemberService.class);

		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
		
	}
	
	@Test
	@DisplayName("이름 없이 타입으로 조회하기")
	void findBeanByType() {

		MemberService memberService = ac.getBean(MemberService.class);

		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("구현체로 조회하기")
	void findBeanByClass() {
		// 좋은 코드는 아님, 참고만 하자(항상 구현이 아니라 역할에 의존하자)
		MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("빈 이름으로 조회되지 않는 경우")
	void findBeanByNameFailed() {
		assertThrows(NoSuchBeanDefinitionException.class,
			() -> ac.getBean("MemberService", // 빈 이름은 대소문자를 구분한다(메소드명 정확하게 !!)
				MemberService.class));
	}
}
