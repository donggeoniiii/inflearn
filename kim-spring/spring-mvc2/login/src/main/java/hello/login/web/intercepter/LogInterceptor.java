package hello.login.web.intercepter;

import java.util.UUID;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {

	private static final String LOG_ID = "logId";

	/**
	 * 핸들러 어댑터 가기 전에 호출
	 * @return true: 계속 진행, false: 차단
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
		Exception {
		String requestURI = request.getRequestURI();
		String uuid = UUID.randomUUID().toString();

		request.setAttribute(LOG_ID, uuid);

		log.info("Request [{}][{}][{}]", uuid, requestURI, handler);

		return true;
	}

	/**
	 * 핸들러(컨트롤러)를 갔다오고 나서 호출, 예외 터지면 호출 안됨
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
		log.info("postHandle [{}]", modelAndView);
	}

	/**
	 * 응답을 핸들러에서 뷰로 전달한 후에 호출, 예외 터져도 호출 됨(모든 경우 호출)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
		Exception ex) throws Exception {
		String requestURI = request.getRequestURI();
		String logId = (String)request.getAttribute(LOG_ID);

		log.info("Response [{}][{}][{}]", logId, requestURI, handler);

		// 예외 발생 경우 출력
		if (ex != null) {
			log.error("afterCompletion Error", ex);
		}
	}
}
