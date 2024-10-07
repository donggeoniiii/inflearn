package hello;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class MemberApp {
	public static void main(String[] args) {
		AppConfig config = new AppConfig();
		MemberService memberService = config.memberService();
		Member member = new Member(1L, "동건", Grade.VIP);
		memberService.join(member);

		Member findMember = memberService.findMember(1L);
		System.out.println(member.getName());
		System.out.println(findMember.getName());
	}
}
