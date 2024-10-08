package hello.core.beanfind;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class ApplicationContextSameBeanFindTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

	@Configuration
	static class SameBeanConfig {

		@Bean
		public MemberRepository memberRepository() {
			return new MemoryMemberRepository();
		}

		@Bean
		public MemberRepository duplicateMemberRepository() {
			return new MemoryMemberRepository();
		}
	}

	@Test
	@DisplayName("타입으로 조회 시 같은 타입이 둘 이상이면 중복 오류가 발생함")
	void findBeanByTypeDuplicated() {
		assertThrows(NoUniqueBeanDefinitionException.class,
			() -> ac.getBean(MemberRepository.class));
	}

	@Test
	@DisplayName("타입으로 조회 시 같은 타입이 둘 이상이면 빈 이름을 지정해준다")
	void findBeanByName() {
		MemberRepository memberRepository = ac.getBean("duplicateMemberRepository", MemberRepository.class);

		assertThat(memberRepository).isInstanceOf(MemoryMemberRepository.class);
	}

	@Test
	@DisplayName("특정 타입을 모두 조회하는 방법")
	void findAllBeansByType() {
		Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);

		for (String key : beansOfType.keySet()) {
			System.out.println(key + ": " + beansOfType.get(key));
		}
		System.out.println("type: " + beansOfType);

		assertThat(beansOfType.size()).isEqualTo(2);
	}
}
