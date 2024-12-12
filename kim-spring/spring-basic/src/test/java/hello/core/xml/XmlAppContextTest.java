package hello.core.xml;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import hello.core.member.MemberService;

public class XmlAppContextTest {

	@Test
	void xmlAppContext() {
		ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
		MemberService memberService = ac.getBean(MemberService.class);

		assertThat(memberService).isInstanceOf(MemberService.class);
	}
}
