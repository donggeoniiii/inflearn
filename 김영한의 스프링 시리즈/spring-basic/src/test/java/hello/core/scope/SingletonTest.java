package hello.core.scope;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class SingletonTest {

	@Test
	void singletonBeanFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
			SingletonBean.class);

		SingletonBean bean1 = ac.getBean(SingletonBean.class);
		SingletonBean bean2 = ac.getBean(SingletonBean.class);

		// 싱글톤 스코프이므로 동일 인스턴스 반환
		assertThat(bean1).isSameAs(bean2);

		ac.close();
	}

	@Scope("singleton")
	private static class SingletonBean {

		@PostConstruct
		void init() {
			System.out.println("SingletonBean.init");
		}

		@PreDestroy
		void destroy() {
			System.out.println("SingletonBean.destroy");
		}
	}
}


