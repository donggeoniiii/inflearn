package hello.springmvc.basic.requestmapping;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MappingController {

	/**
	 * 기본 요청, 모든 메서드에 대해 허용되어 있음
	 * 배열에 넣어 다중 url 배정도 가능
	 */
	@RequestMapping({"/hello-basic", "/hello-go"})
	public String helloBasic() {
		log.info("hello-basic");
		return "ok";
	}

	/**
	 * 특정 http 메서드 요청만 허용
	 * GET, HEAD, POST, PUT, PATCH, DELETE 지원
	 */
	@RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
	public String mappingGetV1() {
		log.info("mapping-get-v1");
		return "ok";
	}

	/**
	 * RequestMapping + http 메서드 축약 어노테이션
	 * GET, POST, PUT, PATCH, DELETE 지원
	 */
	@GetMapping("/mapping-get-v2")
	public String mappingGetV2() {
		log.info("mapping-get-v2");
		return "ok";
	}

	/**
	 * PathVariable 어노테이션 사용
	 * 변수명이 서로 같으면 생략 가능
	 */
	@GetMapping("/mapping/{userId}")
	public String mappingPath(@PathVariable/*("userId")*/ String userId) {
		log.info("mapping-path userId = {}", userId);
		return "ok";
	}

	/**
	 * 다중으로도 가능
	 * 이 경우에도 변수명과 일치하면 생략 가능
	 */
	@GetMapping("/mapping/users/{userId}/orders/{orderId}")
	public String mappingPath(
		@PathVariable/*("userId")*/ String userId,
		@PathVariable/*("orderId")*/ String orderId) {
		log.info("mapping-path userId = {}, orderId = {}", userId, orderId);
		return "ok";
	}

	/**
	 * 특정 파라미터 정보를 바탕으로 매핑
	 * params="mode", "/mapping-param" 뒤에 "mode" 파라미터 있는 경우만 허용
	 * params="!mode" -> "/mapping-param" 뒤에 "mode" 파라미터 있는 경우 차단
	 * params="mode=debug" -> "/mapping-param?mode=debug"만 허용
	 * params="mode!=debug" -> "/mapping-param?mode=debug"만 차단
	 * params = {"mode=debug", "data=good"} -> "/mapping-param" 뒤에 포함되는 쿼리스트링이 있으면 허용
	 * 잘 사용은 안함 참고만
	 */
	@GetMapping(value = "/mapping-param", params = "mode=debug")
	public String mappingParam() {
		log.info("mapping-param");
		return "ok";
	}

	/**
	 * 특정 헤더 조건 매핑
	 * headers="mode", -> 요청 헤더에 "mode"라는 헤더 정보가 있어야 함
	 * headers="!mode" -> 요청 헤더에 "mode"라는 헤더 정보가 없어야 함
	 * headers="mode=debug" -> 요청 헤더에 "mode"라는 헤더 정보가 있고 "debug" 여야 함
	 * headers="mode!=debug" -> 요청 헤더에 "mode"라는 헤더 정보가 있을 시(없어도 됨) "debug"면 안됨
	 */
	@GetMapping(value = "/mapping-header", headers = "mode=debug")
	public String mappingHeader() {
		log.info("mapping-header");
		return "ok";
	}

	/**
	 * Content-Type 헤더 기반 매핑, 미디어 타입을 맞춰야 한다
	 * consume <- 내가 미디어를 소비자인 상황, 요청의 미디어 타입 확인
	 * 안 맞으면 415(Unsupported Media Type) 반환
	 * consumes="application/json" -> json만 받음
	 * consumes="application/*" -> 애플리케이션 형태로 오는 모든 요청 허용
	 * consumes="*\/*" -> 진짜 모든 조건 허용
	 * 그냥 MediaType 클래스에서 enum 타입으로 고르는게 제일 편한 듯
	 */
	@PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String mappingConsume() {
		log.info("mapping-consume");
		return "ok";
	}

	/**
	 * Accept 헤더 기반 매핑, 얘도 미디어 타입을 맞춰야 한다
	 * produce <- 내가 미디어의 제공자인 상황, 클라이언트가 accept 가능하게 해당 타입으로 응답
	 * 안 맞으면 406(Not Acceptable) 반환
	 * produces = "text/plain" -> 순수 텍스트 반환
	 * produces = {"text/plain", "application/*"} -> 둘 중 하나 형태로 반환
	 * produces = "text/plain;charset=UTF-8" -> 텍스트의 인코딩이 UTF-8 이어야 함
	 * 여기도 MediaType 클래스에서 enum 타입으로 고르자
	 */
	@PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
	public String mappingProduces() {
		log.info("mapping-produces");
		return "ok";
	}
}
