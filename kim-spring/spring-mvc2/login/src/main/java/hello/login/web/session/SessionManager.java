package hello.login.web.session;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SessionManager {

	private static final String SESSION_COOKIE_NAME = "mySessionId";

	private final Map<String, Object> sessions = new ConcurrentHashMap<>();

	public void createSession(Object value, HttpServletResponse response) {

		// 세션 아이디 랜덤 생성
		String sessionId = UUID.randomUUID().toString();

		// 세션 아이디와 저장하려는 정보 매핑
		sessions.put(sessionId, value);

		// 쿠키 생성
		Cookie cookie = new Cookie(SESSION_COOKIE_NAME, sessionId);

		response.addCookie(cookie);
	}

	public Object getSession(HttpServletRequest request) {
		Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);

		if (sessionCookie == null) return null;

		return sessions.get(sessionCookie.getValue());
	}

	public void expire(HttpServletRequest request) {
		Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);

		if (sessionCookie != null) {
			sessions.remove(sessionCookie.getValue());
		}
	}

	private Cookie findCookie(HttpServletRequest request, String name) {
		if (request.getCookies() == null) return null;

		return Arrays.stream(request.getCookies())
			.filter(cookie -> cookie.getName().equals(name))
			.findFirst()
			.orElse(null);
	}
}
