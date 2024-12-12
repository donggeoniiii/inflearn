package hello.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.AppConfig;

public class ApplicationContextInfoTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("모든 스프링 빈 출력")
	void findAllBeans() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			Object bean = ac.getBean(beanDefinitionName);
			System.out.println(beanDefinitionName + ": " + bean);
		}
	}

	@Test
	@DisplayName("내가 설정한 스프링 빈 출력")
	void findApplicationBeans() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition definition = ac.getBeanDefinition(beanDefinitionName);

			if (definition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				Object bean = ac.getBean(beanDefinitionName);
				System.out.println(beanDefinitionName + ": " + bean);
			}
		}
	}

	@Test
	@DisplayName("스프링 내부에서 사용하는 빈 출력")
	void findInfraBeans() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition definition = ac.getBeanDefinition(beanDefinitionName);

			if (definition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
				Object bean = ac.getBean(beanDefinitionName);
				System.out.println(beanDefinitionName + ": " + bean);
			}
		}
	}
}
