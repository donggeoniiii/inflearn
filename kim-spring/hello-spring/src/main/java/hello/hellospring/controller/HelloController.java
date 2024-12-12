package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	// 템플릿 방식: 클라이언트에게 요청에 따라 동적으로 만들어진 뷰를 전달
	@GetMapping("hello") // /hello get 요청 처리
	public String hello(Model model) {
		model.addAttribute("data", "hello");
		return "hello"; // resources/templates 에 있는 hello.html 찾기
	}

	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
		model.addAttribute("name", name);
		return "hello-template";
	}

	// api 방식: 뷰 말고 그냥 요청에 맞는 데이터만 쏴준다(보편적)
	@GetMapping("hello-string")
	@ResponseBody // 이 어노테이션을 보면 뷰를 찾지 않고 데이터를 직접 반환한다
	public String helloString(@RequestParam(value = "name") String name) {
		return "hello " + name;
	}

	@GetMapping("hello-api")
	@ResponseBody
	public Hello helloApi(@RequestParam(value = "name") String name) {
		Hello hello = new Hello();
		hello.setName(name);
		return hello;
	}

	static class Hello {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
