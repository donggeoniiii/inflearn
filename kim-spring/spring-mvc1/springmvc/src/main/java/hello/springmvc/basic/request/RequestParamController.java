package hello.springmvc.basic.request;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RequestParamController {

	// 이하 등장하는 내용은 쿼리 스트링으로 uri 전달 시 적용 가능한 방법들이다.

	@RequestMapping("/request-param-v1")
	public void requestParamV1(
		HttpServletRequest request,
		HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));

		log.info("username = {}, age = {}", username, age);

		response.getWriter().write("ok");
	}

	/**
	 * ResponseBody -> 해당하는 뷰를 찾는게 아니라 그냥 문자 반환, @RestController 어노테이션과 같은 효과
	 */
	@ResponseBody
	@RequestMapping("/request-param-v2")
	public String requestParamV2(
		@RequestParam("username") String username,
		@RequestParam("age") int age) {

		log.info("username = {}, age = {}", username, age);

		return "ok";
	}

	/**
	 * 변수명과 요청 파라미터 이름이 같으면 생략 가능
	 */
	@ResponseBody
	@RequestMapping("/request-param-v3")
	public String requestParamV3(
		@RequestParam String username,
		@RequestParam int age) {

		log.info("username = {}, age = {}", username, age);

		return "ok";
	}

	/**
	 * 아예 어노테이션도 생략 가능 (java 컴파일러에 -parameters 옵션 필요)
	 * 근데 좀 과한 거 같기도, 가독성 측면에서 써주는 것이 나음
	 */
	@ResponseBody
	@RequestMapping("/request-param-v4")
	public String requestParamV4(String username, int age) {

		log.info("username = {}, age = {}", username, age);

		return "ok";
	}

	/**
	 * 필수 파라미터 설정
	 * RequestParam 어노테이션이 붙어있는 순간 required 옵션은 기본적으로 true
	 * 만약 해당 파라미터 정보가 안 들어오면 400 Bad Request 반환
	 * null 처리를 위해 특히 숫자형 데이터의 경우 Primitive 클래스가 아니라 Wrapper 클래스 사용
	 * 단 "age=" 처럼 파라미터 정보는 있는 경우 빈 문자열 ("")로 간주되어 통과된다!! 주의하자.
	 */
	@ResponseBody
	@RequestMapping("/request-param-required")
	public String requestParamRequired(
		@RequestParam(required = true) String username,
		@RequestParam(required = false) Integer age) {

		log.info("username = {}, age = {}", username, age);

		return "ok";
	}

	/**
	 * 파라미터 기본값 설정
	 * null 처리를 위해 wrapper 클래스를 사용할 수도 있지만, 기본값으로 처리되게 하는 방법도 있다
	 * 위의 "age=" 같은 경우도 정의된 기본값을 따른다
	 * required 속성은 붙일 수 있으나 별 의미가 없다. 입력되지 않을 시 기본값을 따르기 때문.
	 */
	@ResponseBody
	@RequestMapping("/request-param-default")
	public String requestParamDefault(
		@RequestParam String username,
		@RequestParam(defaultValue = "-1") int age) {

		log.info("username = {}, age = {}", username, age);

		return "ok";
	}

	/**
	 * 파라미터 값을 맵을 통해 조회
	 * 한 파라미터에 여러 값이 들어가는 경우에 MultiValueMap 사용
	 * 어지간하면 한 파라미터에는 하나의 값만 사용하자
	 */
	@ResponseBody
	@RequestMapping("/request-param-map")
	public String requestParamMap(
		@RequestParam MultiValueMap<String, String> paramMap) {
		
		log.info("username = {}, age = {}", paramMap.get("username"), paramMap.get("age"));

		return "ok";
	}

	@ResponseBody
	@RequestMapping("/model-attribute-v1")
	public String modelAttributeV1(
		@RequestParam String username,
		@RequestParam int age) {

		HelloData helloData = new HelloData();
		helloData.setUsername(username);
		helloData.setAge(age);

		log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
		log.info("data = {}", helloData); // 자동으로 만들어진 toString() 호출
		
		return "ok";
	}

	/**
	 * ModelAttribute 어노테이션을 보면 Spring MVC가 자동으로 객체를 만들어준다.
	 * 단, getter, setter 메서드가 있어야 한다.
	 */
	@ResponseBody
	@RequestMapping("/model-attribute-v2")
	public String modelAttributeV2(@ModelAttribute HelloData helloData) {

		log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
		log.info("data = {}", helloData);
		
		return "ok";
	}

	/**
	 * ModelAttribute 어노테이션은 생략이 가능하다.
	 * 단 RequestParam 어노테이션도 마찬가지이므로, 스프링은 규칙에 따라 알아서 적용한다.
	 * argument resolver -> String, int, Integer 등 기본 단순 타입들은 RequestParam 처리
	 * 나머지 -> ModelAttribute 처리
	 * 즉 직접 만든 객체는 ModelAttribute 처리 된다고 생각하면 된다.
	 */
	@ResponseBody
	@RequestMapping("/model-attribute-v3")
	public String modelAttributeV3(HelloData helloData) {

		log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
		
		return "ok";
	}
}
