package hello.core.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

	private final LogDemoService logDemoService;

	// proxy mode 옵션 사용 -> CGLIB 라이브러리로 원본 클래스를 상속한 가짜 프록시 객체를 만들어 주입
	// 프록시 객체는 본인에게 요청이 오면 그제서야 진짜 원본 bean을 요청함
	private final MyLogger myLogger;

	// ObjectProvider 사용 -> request 스코프인 myLogger를 request 수신 이후에 생성하도록 설계
	// private final ObjectProvider<MyLogger> myLoggerProvider;

	@RequestMapping("log-demo")
	@ResponseBody
	public String logDemo(HttpServletRequest request) throws InterruptedException {
		// MyLogger myLogger = myLoggerProvider.getObject();

		String requestURL = request.getRequestURL().toString();
		myLogger.setRequestURL(requestURL);

		System.out.println("myLogger: " + myLogger.getClass()); // class MyLogger$$SpringCGLIB$$0
		myLogger.log("controller test");

		Thread.sleep(1000); // 이 사이 다른 요청이 들어와도 로그가 잘 찍힘(request 별로 별개의 logger 객체 사용)

		logDemoService.logic("testId");
		return "success";
	}
}
