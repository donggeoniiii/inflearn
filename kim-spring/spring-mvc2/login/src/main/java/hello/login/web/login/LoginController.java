package hello.login.web.login;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hello.login.domain.login.LoginService;
import hello.login.domain.member.Member;
import hello.login.web.SessionConst;
import hello.login.web.session.SessionManager;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

	private final LoginService loginService;

	private final SessionManager sessionManager;

	@GetMapping("/login")
	public String login(@ModelAttribute("loginForm") LoginForm loginForm) {
		return "login/loginForm";
	}

	// @PostMapping("/login")
	public String login(@ModelAttribute LoginForm loginForm,
		BindingResult bindingResult, HttpServletResponse response) {
		if (bindingResult.hasErrors()) {
			return "login/loginForm";
		}

		Member loginMember = loginService.login(loginForm.getLoginId(),
			loginForm.getPassword());
		log.info("loginMember = {}", loginMember);

		if (loginMember == null) {
			bindingResult.reject("login.failure");
			return "login/loginForm";
		}

		// 로그인 성공 처리
		Cookie cookie = new Cookie("memberId",
			String.valueOf(loginMember.getId()));
		response.addCookie(cookie);

		return "redirect:/";
	}

	// @PostMapping("/login")
	public String loginV2(@ModelAttribute LoginForm loginForm,
		BindingResult bindingResult, HttpServletResponse response) {

		// 로그인 폼에 바인딩조차 안되는 경우 다시 보내기
		if (bindingResult.hasErrors()) {
			return "login/loginForm";
		}

		// 폼 정보로 로그인 시도
		Member loginMember = loginService.login(loginForm.getLoginId(),
			loginForm.getPassword());
		log.info("loginMember = {}", loginMember);

		// 만약 해당 로그인 정보가 없으면 실패처리
		if (loginMember == null) {
			bindingResult.reject("login.failure");
			return "login/loginForm";
		}

		// 로그인 성공 처리, 세션 id db에 저장
		sessionManager.createSession(loginMember, response);

		return "redirect:/";
	}

	// @PostMapping("/login")
	public String loginV3(@ModelAttribute LoginForm loginForm,
		BindingResult bindingResult, HttpServletRequest request) {

		// 로그인 폼에 바인딩조차 안되는 경우 다시 보내기
		if (bindingResult.hasErrors()) {
			return "login/loginForm";
		}

		// 폼 정보로 로그인 시도
		Member loginMember = loginService.login(loginForm.getLoginId(),
			loginForm.getPassword());
		log.info("loginMember = {}", loginMember);

		// 만약 해당 로그인 정보가 없으면 실패처리
		if (loginMember == null) {
			bindingResult.reject("login.failure");
			return "login/loginForm";
		}

		// 로그인 성공 처리, 세션 id db에 저장
		HttpSession session = request.getSession(); // 세션이 없으면 생성, 이미 있으면 가져오기
		session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

		return "redirect:/";
	}

	@PostMapping("/login")
	public String loginV4(@ModelAttribute LoginForm loginForm,
		BindingResult bindingResult, @RequestParam(defaultValue = "/") String redirectURL,
		HttpServletRequest request) {

		// 로그인 폼에 바인딩조차 안되는 경우 다시 보내기
		if (bindingResult.hasErrors()) {
			return "login/loginForm";
		}

		// 폼 정보로 로그인 시도
		Member loginMember = loginService.login(loginForm.getLoginId(),
			loginForm.getPassword());
		log.info("loginMember = {}", loginMember);

		// 만약 해당 로그인 정보가 없으면 실패처리
		if (loginMember == null) {
			bindingResult.reject("login.failure");
			return "login/loginForm";
		}

		// 로그인 성공 처리, 세션 id db에 저장
		HttpSession session = request.getSession(); // 세션이 없으면 생성, 이미 있으면 가져오기
		session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

		return "redirect:" + redirectURL;
	}

	// @PostMapping("/logout")
	public String logout(HttpServletResponse response) {
		expireLoginCookie(response);

		return "redirect:/";
	}

	// @PostMapping("/logout")
	public String logoutV2(HttpServletRequest request) {
		sessionManager.expire(request);
		return "redirect:/";
	}

	@PostMapping("/logout")
	public String logoutV3(HttpServletRequest request) {
		HttpSession session = request.getSession();

		if (session != null) {
			session.invalidate();
		}

		return "redirect:/";
	}


	private void expireLoginCookie(HttpServletResponse response) {
		// maxAge = 0 쿠키 반환(expired)
		Cookie cookie = new Cookie("memberId", null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
}
