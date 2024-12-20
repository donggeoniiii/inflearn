package hello.springmvc.basic.request;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RequestBodyStringController {

	// 이하 등장하는 내용은 http 요청 시 body에 들어 있는 내용에 적용 가능하다.

	@PostMapping("/request-body-string-v1")
	public void requestBodyStringV1(
		HttpServletRequest request,
		HttpServletResponse response) throws IOException {

		ServletInputStream inputStream = request.getInputStream();
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

		log.info("messageBody = {}", messageBody);

		response.getWriter().write("ok");
	}

	/**
	 * HttpServlet request, response 에서 inputStream, writer 를 바로 가져온다.
	 */
	@PostMapping("/request-body-string-v2")
	public void requestBodyStringV2(InputStream inputStream, Writer responseWriter) throws IOException {

		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		log.info("messageBody = {}", messageBody);

		responseWriter.write("ok");
	}

	/**
	 * HttpEntity -> HTTP 헤더, 바디 정보를 편리하게 조회하게 도와주는 객체
	 * 응답으로도 사용 가능하다(메시지 바디 정보 직접 반환, 뷰 조회 안함)
	 * 이 친구를 상속받은 클래스가 바로 RequestEntity, ResponseEntity !!
	 */
	@PostMapping("/request-body-string-v3")
	public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) {

		String messageBody = httpEntity.getBody();
		log.info("messageBody = {}", messageBody);

		return new HttpEntity<>("ok");
	}

	/**
	 * RequestBody 어노테이션 -> HTTP 요청의 body 안에서 알아서 갖고 온다.
	 * 헤더 정보가 필요하다면 자매품으로 RequestHeader 어노테이션을 사용하자. 같은 역할을 한다.
	 */
	@ResponseBody // request body
	@PostMapping("/request-body-string-v4")
	public String requestBodyStringV4(@RequestBody String messageBody) {

		log.info("messageBody = {}", messageBody);

		return "ok";
	}
}
