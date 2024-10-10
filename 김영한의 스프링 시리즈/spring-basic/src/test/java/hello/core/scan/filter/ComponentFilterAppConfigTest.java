package hello.core.scan.filter;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {
	@Test
	void filterScan() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(
			ComponentFilterAppConfig.class);

		BeanA beanA = ac.getBean(BeanA.class);
		assertThat(beanA).isInstanceOf(BeanA.class);

		assertThrows(
			NoSuchBeanDefinitionException.class,
			() -> ac.getBean(BeanB.class)
		);
	}

	@Configuration
	@ComponentScan(
		// 보통 필터는 annotation 타입으로 사용
		// 사실 includeFilter, excludeFilter(그나마 간혹) 잘 사용할일 없음
		includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
		excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
	)
	static class ComponentFilterAppConfig {

	}
}
