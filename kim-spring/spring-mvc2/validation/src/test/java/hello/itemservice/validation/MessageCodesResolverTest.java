package hello.itemservice.validation;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

public class MessageCodesResolverTest {

	MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

	/**
	 * MessageCodesResolver 메시지 생성 규칙
	 * 1. 객체 오류
	 *  1) code + "." + 객체 이름
	 *  2) code
	 * 2. 필드 오류
	 * 	1) code + "." + 객체 이름 + "." + 필드명
	 * 	2) code + "." + 필드명
	 * 	3) code + "." + 필드타입
	 * 	4) code
	 */
	@Test
	void messageCodesResolverObject() {
		String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");
		assertThat(messageCodes).containsExactly("required.item", "required");
	}

	@Test
	void messageCodesResolverField() {
		String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
		assertThat(messageCodes).containsExactly(
			"required.item.itemName",
			"required.itemName",
			"required.java.lang.String",
			"required");
	}
}
