package hello.itemservice.validation;

import java.util.Set;

import org.junit.jupiter.api.Test;

import hello.itemservice.domain.item.Item;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class BeanValidationTest {

	@Test
	void beanValidation() {
		// 해당 단락은 우리가 스프링과 통합된 기능을 사용하게 되면 직접 작성할 일 x. 참고만 하자
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Item item = new Item();
		item.setItemName(" ");
		item.setPrice(0);
		item.setQuantity(10000);

		Set<ConstraintViolation<Item>> violations = validator.validate(item);

		for (ConstraintViolation<Item> violation : violations) {
			System.out.println(violation.getMessage());
		}
	}
}
