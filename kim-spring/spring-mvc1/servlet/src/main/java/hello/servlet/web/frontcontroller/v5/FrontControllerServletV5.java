package hello.servlet.web.frontcontroller.v5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
@Slf4j
public class FrontControllerServletV5 extends HttpServlet {

	private final Map<String, Object> handlerMappingMap = new HashMap<>();

	private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

	public FrontControllerServletV5() {
		initHandlerMappingMap();
		initHandlerAdapters();
	}

	private void initHandlerAdapters() {
		handlerAdapters.add(new ControllerV3HandlerAdapter());
		handlerAdapters.add(new ControllerV4HandlerAdapter());
	}

	private void initHandlerMappingMap() {
		handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
		handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
		handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());
		handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
		handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
		handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("1. 요청에 맞는 핸들러(컨트롤러) 찾기");
		Object handler = getHandler(request);

		if (handler == null) {
			log.error("1-fail. 요청이 잘못된 경우 404 not found");
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		log.info("2. 해당 핸들러를 처리할 수 있는 어댑터 찾기");
		MyHandlerAdapter adapter = getHandlerAdapter(handler);

		ModelView modelView = adapter.handle(request, response, handler);

		log.info("4. 모델 정보를 바탕으로 알맞은 뷰 생성");
		String viewName = modelView.getViewName();
		MyView myView = viewResolver(viewName);
		
		myView.render(modelView.getModel(), request, response);

	}

	private MyHandlerAdapter getHandlerAdapter(Object handler) {
		for (MyHandlerAdapter adapter : handlerAdapters) {
			if (adapter.supports(handler)) {
				return adapter;
			}
		}

		log.error("2-fail. 만약 없다면 예외 던지기");
		throw new IllegalArgumentException("no handler adapter: " + handler);
	}

	private Object getHandler(HttpServletRequest request) {
		String requestURI = request.getRequestURI();

		return handlerMappingMap.get(requestURI);
	}

	private MyView viewResolver(String viewName) {
		return new MyView("/WEB-INF/views/" + viewName + ".jsp");
	}

}
