package hello.core.web;

import org.springframework.stereotype.Service;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogDemoService {

	// proxy mode 옵션 사용 -> CGLIB 라이브러리로 원본 클래스를 상속한 가짜 프록시 객체를 만들어 주입
	// 프록시 객체는 본인에게 요청이 오면 그제서야 진짜 원본 bean을 요청함
	private final MyLogger myLogger;

	// // provider 사용 -> request 스코프인 myLogger를 request 수신 이후에 생성하도록 설계
	// private final ObjectProvider<MyLogger> myLoggerProvider;

	// -> 두 방식의 공통점: 객체 조회를 진짜 필요한 시점까지 지연했다 처리한다는 점
	// 심지어 클라이언트 코드를 건들지 않음!!

	public void logic(String id) {
		// MyLogger myLogger = myLoggerProvider.getObject();
		myLogger.log("service ID: " + id);
	}
}
