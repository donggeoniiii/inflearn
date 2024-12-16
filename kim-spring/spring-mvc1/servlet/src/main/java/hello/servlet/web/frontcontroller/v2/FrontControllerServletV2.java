package hello.servlet.web.frontcontroller.v2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*") // 하위 요청 전부 얘한테 옴
@Slf4j
public class FrontControllerServletV2 extends HttpServlet {

	private final Map<String, ControllerV2> controllerMap = new HashMap<>();

	public FrontControllerServletV2() {
		controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
		controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
		controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("FrontControllerServletV2.service");

		String requestURI = request.getRequestURI();

		ControllerV2 controller = controllerMap.get(requestURI);

		// 요청이 잘못된 경우 404 not found
		if (controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		MyView view = controller.process(request, response);

		view.render(request, response);
	}
}
