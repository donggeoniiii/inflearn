package hello.springmvc.basic.request;

import java.util.Locale;

import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RequestHeaderController {

	/**
	 * http request 헤더 정보 받아오기
	 * 스프링 홈페이지를 가면 조회할 수 있는 헤더 정보들에 대해 알아볼 수 있다
	 */
	@GetMapping("/headers")
	public String headers(
		HttpServletRequest request,
		HttpServletResponse response,
		HttpMethod httpMethod,
		Locale locale,
		@RequestHeader MultiValueMap<String, String> headerMap, // 헤더 전체
		@RequestHeader("host") String host, // 특정 헤더 1개
		@CookieValue(value = "myCookie", required = false) String cookie) {

		log.info("request = {}", request);
		log.info("response = {}", response);
		log.info("httpMethod = {}", httpMethod);
		log.info("locale = {}", locale);
		log.info("headerMap = {}", headerMap);
		log.info("host = {}", host);
		log.info("cookie = {}", cookie);

		return "ok";
	}
}
