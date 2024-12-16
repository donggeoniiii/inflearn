package hello.servlet.web.frontcontroller.v3.controller;

import java.util.List;
import java.util.Map;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberListControllerV3 implements ControllerV3 {

	private final MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public ModelView process(Map<String, String> paramMap) {
		log.info("3. 해당 path controller 실행");

		List<Member> members = memberRepository.findAll();

		ModelView modelView = new ModelView("members");
		modelView.getModel().put("members", members);

		return modelView;
	}
}
