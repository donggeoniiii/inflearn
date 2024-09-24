package hello.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;

// 클래스에 @Component 어노테이션이 붙으면 실행 시 spring 컨테이너가 spring bean으로 관리함
// @Controller, @Service, @Repository 가 해당함
@Controller
public class MemberController {

	/* @Autowired */ // 의존성 주입(필드 주입)
	private final MemberService memberService;

	// 의존성 주입(setter 주입)
	/*
	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}*/

	// 의존성 주입(생성자 주입)
	// 어차피 실행될 때 한번만 등록되면 다시 바뀔 일 없으므로 권장되는 방법
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/members/new")
	public String createForm() {
		return "members/createMemberForm";
	}

	@PostMapping("/members/new")
	public String create(MemberForm memberForm) {
		Member member = new Member();
		member.setName(memberForm.getName());

		memberService.join(member);

		return "redirect:/";
	}

	@GetMapping("/members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members);
		return "members/memberList";
	}
}