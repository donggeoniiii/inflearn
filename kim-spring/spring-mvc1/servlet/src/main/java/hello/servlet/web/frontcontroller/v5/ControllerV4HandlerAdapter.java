package hello.servlet.web.frontcontroller.v5;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
	@Override
	public boolean supports(Object handler) {
		return (handler instanceof ControllerV4);
	}

	@Override
	public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
		ServletException,
		IOException {
		log.info("3. 비즈니스 로직 처리 - ControllerV4");

		ControllerV4 controller = (ControllerV4) handler;

		Map<String, String> paramMap = createParamMap(request);
		Map<String, Object> model = new HashMap<>();

		String viewName = controller.process(paramMap, model);

		log.info("3-1. 어댑터가 modelView 반환 포맷에 맞추기 위해 뷰 생성");
		ModelView modelView = new ModelView(viewName);
		modelView.setModel(model);

		return modelView;
	}

	private Map<String, String> createParamMap(HttpServletRequest request) {
		Map<String, String> paramMap = new HashMap<>();
		request.getParameterNames().asIterator()
			.forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
		return paramMap;
	}
}
