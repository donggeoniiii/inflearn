package hello.springmvc.basic.request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RequestBodyJsonController {

	// 해당 내용은 http 요청의 body에서 데이터를 꺼내오는 경우로, @RequestParam 과 @ModelAttribute 와는 무관하다.

	// 문자로 된 json 데이터를 java 객체로 변환
	private final ObjectMapper objectMapper = new ObjectMapper();

	@PostMapping("/request-body-json-v1")
	public void requestBodyJsonV1(
		HttpServletRequest request,
		HttpServletResponse response) throws IOException {

		ServletInputStream inputStream = request.getInputStream();
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

		log.info("messageBody = {}", messageBody);
		HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
		log.info("helloData = {}", helloData);

		response.getWriter().write("ok");
	}

	@ResponseBody
	@PostMapping("/request-body-json-v2")
	public String requestBodyJsonV2(@RequestBody String messageBody) throws IOException {

		log.info("messageBody = {}", messageBody);

		HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
		log.info("helloData = {}", helloData);

		return "ok";
	}

	/**
	 * RequestBody 어노테이션을 통해 HTTP 요청 내 body에 있는 json 자료를 가져올 수 있다.
	 * 이를 바탕으로 json을 처리하는 HTTP 메시지 컨버터가 객체를 생성해준다.
	 * RequestBody 어노테이션 생략은 불가능: 기본형 객체가 아니면 ModelAttribute 처리되도록 되어 있으므로
	 */
	@ResponseBody
	@PostMapping("/request-body-json-v3")
	public String requestBodyJsonV3(@RequestBody HelloData helloData) {

		log.info("helloData = {}", helloData);

		return "ok";
	}

	/**
	 * HTTP Entity 사용
	 * HttpEntity에서 getBody()를 호출해 직접 정보를 꺼낼 거나까 @RequestBody 없어도 됨
	 */
	@ResponseBody
	@PostMapping("/request-body-json-v4")
	public String requestBodyJsonV4(HttpEntity<HelloData> httpEntity) {

		HelloData helloData = httpEntity.getBody();
		log.info("helloData = {}", helloData);

		return "ok";
	}

	/**
	 * ResponseBody 어노테이션을 붙이면 객체를 http 응답 body에 넣어준다.
	 * 마찬가지로 HttpEntity를 사용하는 방법이 있다.
	 */
	@ResponseBody
	@PostMapping("/request-body-json-v5")
	public HelloData requestBodyJsonV5(@RequestBody HelloData helloData) {
		log.info("helloData = {}", helloData);
		return helloData;
	}
}
