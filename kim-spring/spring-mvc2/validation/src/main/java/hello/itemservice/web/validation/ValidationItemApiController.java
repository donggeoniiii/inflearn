package hello.itemservice.web.validation;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.itemservice.web.validation.dto.ItemSaveRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/validation/api/items")
public class ValidationItemApiController {

	@PostMapping("/add")
	public Object addItem(@RequestBody @Validated ItemSaveRequest itemSaveRequest, BindingResult bindingResult) {
		log.info("api 컨트롤러 호출");

		// 요구사항 반영: 가격 * 수량의 합이 10000 이상
		if (itemSaveRequest.getPrice() != null && itemSaveRequest.getQuantity() != null) {
			int result = itemSaveRequest.getPrice() * itemSaveRequest.getQuantity();

			if (result < 10000) {
				bindingResult.reject("total.price.min", new Object[] {10000, result}, null);
			}
		}

		if (bindingResult.hasErrors()) {
			log.info("errors={}", bindingResult);

			return bindingResult.getAllErrors();
		}

		log.info("성공 로직 실행");
		return itemSaveRequest;
	}
}
