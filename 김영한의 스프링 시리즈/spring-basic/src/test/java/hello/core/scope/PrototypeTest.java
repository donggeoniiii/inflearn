package hello.core.scope;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import jakarta.annotation.PostConstruct;

public class PrototypeTest {

	@Test
	void prototypeBeanFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
			PrototypeBean.class);

		PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
		PrototypeBean bean2 = ac.getBean(PrototypeBean.class);

		System.out.println(bean1);
		System.out.println(bean2);

		// 프로토타입 스코프인 경우 요청마다 새 인스턴스 반환
		assertThat(bean1).isNotSameAs(bean2);
		
		ac.close(); // 따로 메서드 만들어서 해줘야 함(책임이 클라이언트에게 있음)
	}

	@Scope("prototype")
	private static class PrototypeBean {
		@PostConstruct
		void init() {
			System.out.println("PrototypeBean.init");
		}

		// @PreDestroy // compile error: 허용 안됨
	}
}
