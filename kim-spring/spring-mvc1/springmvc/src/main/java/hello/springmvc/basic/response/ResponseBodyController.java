package hello.springmvc.basic.response;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
// @RestController <- @Controller + @ResponseBody
public class ResponseBodyController {

	@GetMapping("/response-body-string-v1")
	public void responseBodyStringV1(HttpServletResponse response) throws IOException {

		response.getWriter().write("ok");
	}

	/**
	 * ResponseEntity 사용해서 HTTP Status 함께 전달
	 */
	@GetMapping("/response-body-string-v2")
	public ResponseEntity<String> responseBodyStringV2() {

		return new ResponseEntity<>("ok", HttpStatus.OK);
	}

	/**
	 * ResponseBody 어노테이션으로 바로 바디에 문자 입력
	 */
	@ResponseBody
	@GetMapping("/response-body-string-v3")
	public String responseBodyStringV3() {
		return "ok";
	}

	@GetMapping("/response-body-json-v1")
	public ResponseEntity<HelloData> responseBodyJsonV1() {
		HelloData helloData = new HelloData();
		helloData.setUsername("icebear");
		helloData.setAge(28);

		return new ResponseEntity<>(helloData, HttpStatus.OK);
	}

	/**
	 * ResponseStatus 어노테이션으로 status 표기,
	 * ResponseBody 어노테이션으로 바로 바디에 json 데이터 입력
	 * 응답코드를 동적으로 변경할 수 없음, 필요한 경우 ResponseEntity 사용할 것
	 */
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@GetMapping("/response-body-json-v2")
	public HelloData responseBodyJsonV2() {
		HelloData helloData = new HelloData();
		helloData.setUsername("icebear");
		helloData.setAge(28);

		return helloData;
	}
}
