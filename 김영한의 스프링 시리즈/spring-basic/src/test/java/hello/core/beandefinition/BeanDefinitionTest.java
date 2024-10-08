package hello.core.beandefinition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.AppConfig;

public class BeanDefinitionTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	// GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

	@Test
	@DisplayName("빈 설정 메타 정보를 확인한다")
	void findApplicationBean() {

		// 스프링은 BeanDefinition을 통해 bean의 메타 정보를 추상화
		// xml, annotation 등 방식에 따라 각각의 reader가 BeanDefinition을 만든다
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition definition = ac.getBeanDefinition(beanDefinitionName);

			if (definition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				System.out.println(beanDefinitionName + ": " + definition);
			}
		}
	}
}

