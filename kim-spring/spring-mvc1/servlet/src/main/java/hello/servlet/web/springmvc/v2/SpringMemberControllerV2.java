package hello.servlet.web.springmvc.v2;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/springmvc/v2/members") // 메서드에 붙은 request mapping(get/post/put mapping 등 포함)과 결합
public class SpringMemberControllerV2 {

	private final MemberRepository memberRepository = MemberRepository.getInstance();

	@RequestMapping("/new-form")
	public ModelAndView newForm() {
		return new ModelAndView("new-form");
	}

	@RequestMapping("/save")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));

		Member member = new Member(username, age);
		memberRepository.save(member);

		ModelAndView mv = new ModelAndView("save-result");

		// mv.getModel().put("member", member)와 같은 코드
		mv.addObject("member", member);

		return mv;
	}

	@RequestMapping("")
	public ModelAndView members() {

		List<Member> members = memberRepository.findAll();

		ModelAndView mv = new ModelAndView("members");
		mv.addObject("members", members);

		return mv;
	}
}
