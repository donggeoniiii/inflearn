package hello.core.singleton;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class StatefulServiceTest {

	@Configuration
	static class TestConfig {
		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}

	@Test
	void statefulServiceSingleton() {
 		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

		StatefulService s1 = ac.getBean(StatefulService.class);
		StatefulService s2 = ac.getBean(StatefulService.class);

		int price1 = s1.order("동건", 1000);
		int price2 = s2.order("어름곰", 1_000_000);

		assertThat(price1).isEqualTo(1000);
		assertThat(price2).isEqualTo(1_000_000);
	}
}