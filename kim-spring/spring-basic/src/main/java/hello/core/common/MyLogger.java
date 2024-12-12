package hello.core.common;

import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Setter;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

	private String uuid;

	@Setter
	private String requestURL; // 생성 시점 기준으로 알 수 없음으로 setter 사용해 주입

	public void log(String msg) {
		System.out.println("[" + uuid + "][" + msg + "][" + requestURL + "] " + msg);
	}

	@PostConstruct
	void init() {
		uuid = UUID.randomUUID().toString();
		System.out.println("[" + uuid + "] request scope bean created: " + this);
	}

	@PreDestroy
	void close() {
		System.out.println("[" + uuid + "] request scope bean closed: " + this);
	}
}
