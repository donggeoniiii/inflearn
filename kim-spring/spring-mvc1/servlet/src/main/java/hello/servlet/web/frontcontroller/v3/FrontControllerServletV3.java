package hello.servlet.web.frontcontroller.v3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*") // 하위 요청 전부 얘한테 옴
@Slf4j
public class FrontControllerServletV3 extends HttpServlet {

	private final Map<String, ControllerV3> controllerMap = new HashMap<>();

	public FrontControllerServletV3() {
		controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
		controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
		controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("1. FrontControllerServlet 호출");

		String requestURI = request.getRequestURI();

		ControllerV3 controller = controllerMap.get(requestURI);

		// 요청이 잘못된 경우 404 not found
		if (controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		log.info("2. request 정보 paramMap 입력");
		Map<String, String> paramMap = createParamMap(request);
		ModelView modelView = controller.process(paramMap);

		log.info("4. model 내용 토대로 뷰 정보 생성");
		String viewName = modelView.getViewName();
		MyView myView = viewResolver(viewName);

		log.info("5. model 전달, 뷰 생성");
		myView.render(modelView.getModel(), request, response);
	}

	private MyView viewResolver(String viewName) {
		return new MyView("/WEB-INF/views/" + viewName + ".jsp");
	}

	private Map<String, String> createParamMap(HttpServletRequest request) {
		Map<String, String> paramMap = new HashMap<>();
		request.getParameterNames().asIterator()
				.forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
		return paramMap;
	}
}
