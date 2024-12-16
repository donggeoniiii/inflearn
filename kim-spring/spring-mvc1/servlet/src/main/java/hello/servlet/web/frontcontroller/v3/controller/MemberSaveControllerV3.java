package hello.servlet.web.frontcontroller.v3.controller;

import java.util.Map;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberSaveControllerV3 implements ControllerV3 {

	private final MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public ModelView process(Map<String, String> paramMap) {
		log.info("3. 해당 path controller 실행");

		log.info("3-1. paramMap 통해 필요한 정보 꺼내기");
		String username = paramMap.get("username");
		int age = Integer.parseInt(paramMap.get("age"));

		Member member = new Member(username, age);
		memberRepository.save(member);

		log.info("3-2. paramMap 통해 response 정보 전달");
		ModelView modelView = new ModelView("save-result");
		modelView.getModel().put("member", member);

		return modelView;
	}
}
