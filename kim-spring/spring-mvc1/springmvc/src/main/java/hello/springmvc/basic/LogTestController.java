package hello.springmvc.basic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LogTestController {

	@RequestMapping("/log-test")
	public String logTest() {
		String name = "Spring";

		log.trace("trace log = {}", name);
		log.debug("debug log = {}", name);
		log.info(" info log = {}", name);
		log.warn(" warn log = {}", name);
		log.error("error log = {}", name);

		// a+b 계산 로직이 실제로 실행되므로 로그를 사용하는 이유 없음, 이런 방식으로 사용 X
		log.debug("String concat log = " + name);
		return "ok";
	}
}