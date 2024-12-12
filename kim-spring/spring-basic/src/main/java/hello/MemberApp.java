package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class MemberApp {
	public static void main(String[] args) {
		// AppConfig config = new AppConfig();
		// MemberService memberService = config.memberService();

		// Configuration 어노테이션이 붙은 AppConfig 클래스에 있는 설정 정보를 바탕으로 스프링 실행 예정
		// ApplicationContext == 스프링 컨테이너
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		// name은 bean 어노테이션으로 등록된 메서드명을 사용
		MemberService memberService = ac.getBean("memberService", MemberService.class);

		Member member = new Member(1L, "동건", Grade.VIP);
		memberService.join(member);

		Member findMember = memberService.findMember(1L);
		System.out.println(member.getName());
		System.out.println(findMember.getName());
	}
}
