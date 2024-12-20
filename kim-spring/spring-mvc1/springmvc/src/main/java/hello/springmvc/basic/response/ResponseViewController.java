package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

	@RequestMapping("/response-view-v1")
	public ModelAndView responseViewV1() {

		return new ModelAndView("response/hello")
			.addObject("data", "hello");
	}

	/**
	 * ResponseBody 어노테이션 없이 String 반환 -> 뷰 리졸버 실행
	 * resources/templates/ + {논리 view 이름} + .html 렌더링
	 */
	@RequestMapping("/response-view-v2")
	public String responseViewV2(Model model) {

		model.addAttribute("data", "hello");

		return "response/hello";
	}

	/**
	 * 응답을 따로 처리해주지 않으면 요청 url을 논리 view 이름으로 사용
	 * resources/templates/ + {요청 url} + .html 렌더링
	 * 명시성이 너무 떨어지고 딱 맞아 떨어지기도 어려워서 권장되지 않는 방법
	 */
	@RequestMapping("/response/hello")
	public void responseViewV3(Model model) {
		model.addAttribute("data", "hello");
	}

	/*
	 참고로 타임리프 라이브러리를 추가하면 알아서 뷰 리졸버랑 관련 스프링 빈이 등록된다.
	 기본적으로 resources/templates 이하 디렉터리를 사용하고, 기본 확장자로 .html 받는다(변경 가능)
	 */
}
