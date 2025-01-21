package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import hello.login.web.argumentresolver.Login;
import hello.login.web.session.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;

    private final SessionManager sessionManager;

    // @GetMapping("/")
    public String homeLogin(
        @CookieValue(name = "memberId", required = false) Long memberId, Model model) {

        // 로그인하지 않은 경우 기본 화면
        if (memberId == null) {
            return "home";
        }

        // id로 로그인한 회원정보 찾기
        Member loginMember = memberRepository.findById(memberId);

        // 그런 사실 없으면 기본 화면
        if (loginMember == null) {
            return "home";
        }

        model.addAttribute("member", loginMember);
        return "loginHome";
    }

    // @GetMapping("/")
    public String homeLoginV2(HttpServletRequest request, Model model) {

        // 세션에 저장된 로그인 정보 가져오기
        Member loginMember = (Member) sessionManager.getSession(request);

        // 없으면 기본 화면
        if (loginMember == null) {
            return "home";
        }

        model.addAttribute("member", loginMember);
        return "loginHome";
    }

    // @GetMapping("/")
    public String homeLoginV3(HttpServletRequest request, Model model) {

        // 세션 생성 의도가 없으므로 false 옵션 붙이기
        HttpSession session = request.getSession(false);

        if (session == null) {
            return "home";
        }

        // 세션에 저장된 정보 꺼내기
        Member loginMember = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);

        model.addAttribute("member", loginMember);
        return "loginHome";
    }

    // @GetMapping("/")
    public String homeLoginV3Spring(@SessionAttribute(
        name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember,
        Model model) {

        // 로그인 정보 없으면 기본 화면
        if (loginMember == null) {
            return "home";
        }

        model.addAttribute("member", loginMember);
        return "loginHome";
    }

    @GetMapping("/")
    public String homeLoginV3ArgumentResolver(@Login Member loginMember,
        Model model) {

        // 로그인 정보 없으면 기본 화면
        if (loginMember == null) {
            return "home";
        }

        model.addAttribute("member", loginMember);
        return "loginHome";
    }
}