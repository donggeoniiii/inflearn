package hello.itemservice.web.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import hello.itemservice.domain.item.Item;

@Component
public class ItemValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Item.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Item item = (Item) target;

		// 상품 이름 없음
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemName", "required");

		// 비정상적 상품 가격
		if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1_000_000) {
			errors.rejectValue("price", "range", new Object[] {1000, 1_000_000}, null);
		}

		// 비정상적인 상품 수량
		if (item.getQuantity() == null || item.getQuantity() < 0 || item.getQuantity() >= 9999) {
			errors.rejectValue("quantity", "max", new Object[] {9999}, null);
		}
	}
}
