package jpabook.jpashop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import jpabook.jpashop.dto.MemberForm;
import jpabook.jpashop.dto.MemberView;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	/**
	 * 회원가입 폼
	 */
	@GetMapping("/new")
	public String createMemberForm(Model model) {
		model.addAttribute("memberForm", new MemberForm());
		return "members/createMemberForm";
	}

	/**
	 * 회원가입
	 */
	@PostMapping("/new")
	public String createMember(@Valid MemberForm memberForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "members/createMemberForm";
		}
		memberService.join(memberForm);

		return "redirect:/";
	}

	/**
	 * 회원 목록 조회
	 */
	@GetMapping("")
	public String list(Model model) {
		List<MemberView> members = memberService.findMembers();
		model.addAttribute("members", members);
		return "members/memberList";
	}
}
