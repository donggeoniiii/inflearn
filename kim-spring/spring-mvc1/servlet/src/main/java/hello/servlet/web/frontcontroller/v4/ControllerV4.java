package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {

	/**
 	 * 비즈니스 로직 처리
	 * @param paramMap 요청으로 들어온 파라미터 정보
	 * @param model 처리된 비즈니스 로직의 산출물 정보
	 * @return viewName
	 */
	String process(Map<String, String> paramMap, Map<String, Object> model);
}
