package hello.servlet.web.frontcontroller.v3.controller;

import java.util.Map;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberFormControllerV3 implements ControllerV3 {

	@Override
	public ModelView process(Map<String, String> paramMap) {
		log.info("3. 해당 path controller 실행");
		return new ModelView("new-form");
	}
}
