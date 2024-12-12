package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Setter;

@Setter
public class NetworkClient /*implements InitializingBean, DisposableBean*/ {
	// 인터페이스를 구현하는 방식은 이젠 잘 사용하지 않음!

	private String url;

	public NetworkClient() {
		System.out.println("생성자 호출, url = " + url);
	}

	void connect() {
		System.out.println("NetworkClient.connect: " + url);
	}

	void call(String message) {
		System.out.println("NetworkClient.call: " + url + ", message: " + message);
	}

	void disconnect() {
		System.out.println("NetworkClient.disconnect: " + url);
	}

	// 스프링 빈 생성 및 의존관계 설정 후 스프링이 터트리는 콜백 함수
	@PostConstruct // java 공식 방법(spring 아니어도 사용 가능, spring 플젝에서도 권장)
	public void init() {
		System.out.println("NetworkClient.init");
		connect();
		call("초기화 연결 메시지");
	}

	// 스프링 빈이 소멸하기 전 미리 알려주는 콜백 함수
	@PreDestroy
	public void close() {
		System.out.println("NetworkClient.close");
		disconnect();
	}
}
