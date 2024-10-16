package hello.core.autowired;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Member;
import jakarta.annotation.Nullable;

public class AutowiredTest {
	@Test
	void AutowiredOption() {
		new AnnotationConfigApplicationContext(TestBean.class);
	}

	static class TestBean {
		@Autowired(required = false) // 불러올 객체가 스프링 빈이 아니면 호출자체를 안함
		public void setNoBean1(Member noBean1) {
			System.out.println("noBean1 = " + noBean1);
		}

		@Autowired // 불러올 객체가 스프링 빈이 아니면 null 출력
		public void setNoBean2(@Nullable Member noBean2) {
			System.out.println("noBean2 = " + noBean2);
		}

		@Autowired // 불러올 객체가 스프링 빈이 아니면 Optional.empty 출력
		public void setNoBean3(Optional<Member> noBean3) {
			System.out.println("noBean3 = " + noBean3);
		}
	}

}
