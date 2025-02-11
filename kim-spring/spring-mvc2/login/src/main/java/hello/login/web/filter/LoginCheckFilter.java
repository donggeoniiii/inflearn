package hello.login.web.filter;

import java.io.IOException;

import org.springframework.util.PatternMatchUtils;

import hello.login.web.SessionConst;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginCheckFilter implements Filter {

	private static final String[] whitelist = {"/", "/members/add", "/login", "/logout", "/css/*"};

	@Override
	public void doFilter(ServletRequest servletRequest,
		ServletResponse servletResponse, FilterChain filterChain) throws
		IOException,
		ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		String requestURI = request.getRequestURI();

		HttpServletResponse response = (HttpServletResponse) servletResponse;

		try {
			log.info("인증 체크 필터 시작 {}", requestURI);

			// 화이트리스트 체크
			if (isPathNeedsAuthentication(requestURI)) {
				log.info("인증 체크 로직 실행 {}", requestURI);

				HttpSession session = request.getSession(false);
				if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
					log.info("미인증 시용자 요청 {}", requestURI);

					response.sendRedirect("/login?redirectURL=" + requestURI);
					return;
				}
			}

			filterChain.doFilter(request, response);
		} catch (Exception e) {
			throw e;
		} finally {
			log.info("인증 체크 필터 종료 {}", requestURI);
		}
	}

	private boolean isPathNeedsAuthentication(String requestURI) {
		return !PatternMatchUtils.simpleMatch(whitelist, requestURI);
	}
}
