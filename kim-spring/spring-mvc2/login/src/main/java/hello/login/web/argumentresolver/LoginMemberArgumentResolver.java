package hello.login.web.argumentresolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import hello.login.domain.member.Member;
import hello.login.web.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginMemberArgumentResolver implements HandlerMethodArgumentResolver {

	/**
	 * argument resolver 지원 여부 체크
	 * 한번 실행되면 캐싱되어서 매번 호출되진 않음
	 * @return 지원 되는 경우 true, 안되면 false
	 */
	@Override
	public boolean supportsParameter(MethodParameter parameter) {

		log.info("supportsParameter 실행");

		// 로그인 어노테이션이 붙었는지
		boolean hasLoginAnnotation = parameter.hasParameterAnnotation(Login.class);

		// 해당하는 파라미터가 Member 변수인지
		boolean hasMemberType = Member.class.isAssignableFrom(parameter.getParameterType());

		// 둘다 해당하는 경우에만 ArgumentResolver 의미 있음
		return hasLoginAnnotation && hasMemberType;
	}

	/**
	 * 세션에서 로그인된 유저 찾아서 반환하기
	 * @return 로그인 된 경우 로그인된 유저 정보, 아니면 null
	 */
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
		NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

		log.info("resolveArgument 실행");

		HttpServletRequest request = (HttpServletRequest)webRequest.getNativeRequest();

		HttpSession session = request.getSession();

		if (session == null) return null;

		return session.getAttribute(SessionConst.LOGIN_MEMBER);
	}
}
