package hello.core.scope;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Provider;
import lombok.Getter;

public class SingletonWithPrototypeTest {

	@Test
	void prototypeFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
			PrototypeBean.class);

		PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
		PrototypeBean bean2 = ac.getBean(PrototypeBean.class);

		bean1.addCount();
		bean2.addCount();

		// 서로 다른 두 인스턴스에서 발생했으므로 독립적으로 카운팅됨
		System.out.println("bean1: " + bean1.getCount());
		System.out.println("bean2: " + bean2.getCount());
		assertThat(bean1.getCount()).isEqualTo(1);
		assertThat(bean2.getCount()).isEqualTo(1);
	}

	@Test
	void singletonClientUsePrototype() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

		ClientBean bean1 = ac.getBean(ClientBean.class);
		ClientBean bean2 = ac.getBean(ClientBean.class);

		int count1 = bean1.logic();
		assertThat(count1).isEqualTo(1);

		int count2 = bean2.logic();
		assertThat(count2).isEqualTo(1);

		int count3 = bean2.logic();
		assertThat(count3).isEqualTo(1);
	}

	@Scope("singleton")
	private static class ClientBean {
		// Provider: 프로토타입 문제 말고도 DL(Dependency Lookup)이 필요하면 언제든 사용함
		// 단 의존 관계 추가가 필요
		private final Provider<PrototypeBean> provider;

		@Autowired
		public ClientBean(Provider<PrototypeBean> provider) {
			this.provider = provider;
		}

		// ObjectProvider -> 스프링 프레임워크에 의존적, 근데 대부분은 스프링이라 어지간하면 써도 됨
		// private final ObjectProvider<PrototypeBean> prototypeBeanProvider;
		// @Autowired
		// ClientBean(ObjectProvider<PrototypeBean> prototypeBeanProvider) {
		// 	this.prototypeBeanProvider = prototypeBeanProvider;
		// }

		// 생성 시점에 주입, 이후 참조값이 바뀔 일 없으니 프로토타입 빈인데도 같은 객체 반환
		// @Autowired
		// public ClientBean(PrototypeBean prototypeBean) {
		// 	this.prototypeBean = prototypeBean;
		// }

		int logic() {
			// 항상 새로운 프로토타입 빈 반환
			PrototypeBean prototypeBean = provider.get();
			prototypeBean.addCount();
			return prototypeBean.getCount();
		}
	}

	@Scope("prototype")
	@Getter
	private static class PrototypeBean {

		@PostConstruct
		void init() {
			System.out.println("PrototypeBean init");
		}

		private int count;

		void addCount() { count++; }
	}

}
