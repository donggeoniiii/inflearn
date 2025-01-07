package hello.itemservice.message;

import static org.assertj.core.api.Assertions.*;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

@SpringBootTest
public class MessageSourceTest {

	@Autowired
	MessageSource messageSource;

	@Test
	void helloMessageDefault() {
		String defaultMessage = messageSource.getMessage("hello", null, null);

		assertThat(defaultMessage).isEqualTo("안녕");
	}

	@Test
	void helloMessageEnglish() {
		String englishMessage = messageSource.getMessage("hello", null, Locale.ENGLISH);

		assertThat(englishMessage).isEqualTo("hello");
	}

	@Test
	void messageNotFound() {
		assertThatThrownBy(() -> messageSource.getMessage(
			"goodbye", null, null))
			.isInstanceOf(NoSuchMessageException.class);
	}

	@Test
	void messageNotFoundDefaultMessage() {
		String messageWhenNotFound = messageSource.getMessage("goodbye", null, "기본 메시지", null);

		assertThat(messageWhenNotFound).isEqualTo("기본 메시지");
	}

	@Test
	void argumentMessage() {
		String argumentMessage = messageSource.getMessage("hello.name", new Object[] {"Spring"}, null);

		assertThat(argumentMessage).isEqualTo("안녕 Spring");
	}

}
