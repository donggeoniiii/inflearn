package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class BeanLifeCycleTest {

	@Test
	void lifeCycleTest() {
		ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);

		ac.getBean(NetworkClient.class);
		ac.close();
	}

	@Configuration
	static class LifeCycleConfig {

		/* 
		'destroyMethod' 속성은 close()나 shutdown()라는 이름의 메서드를 자동 추론해서 실행함! 
		그래서 이름만 잘 지으면 명시적으로 쓰지 않아도 됨
		만약 추론기능 쓰기 싫으면 destroyMethod 설정값을 빈 문자열("")로 하면 된다
		코드를 고칠 수 없는 외부 라이브러리를 받아올 때 사용
		그 이외는 java 표준의 @PreConstruct, @PreDestroy 어노테이션을 사용하자
		 */
		@Bean /*(initMethod = "init", destroyMethod = "close")*/
		public NetworkClient networkClient() {
			NetworkClient nc = new NetworkClient();
			nc.setUrl("https://hello-spring.dev");
			return nc;
		}
	}
}
