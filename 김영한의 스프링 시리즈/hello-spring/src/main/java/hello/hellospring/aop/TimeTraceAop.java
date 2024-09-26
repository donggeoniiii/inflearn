package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

	@Around("execution(* hello.hellospring..*(..))") // 이건 Spring AOP 매뉴얼 상세 참고!
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		// aop가 적용되면 해당 코드는 프록시를 통해 실행
		long start = System.currentTimeMillis();
		System.out.println("START: " + joinPoint.toString());
		try {
			return joinPoint.proceed(); // 여기부터 진짜 
		} finally {
			// 핵심 로직이 proceed()를 타고 다 실행되면 다시 나머지 실행
			long finish = System.currentTimeMillis();
			long time = finish - start;
			System.out.println("END: " + joinPoint + ": " + time + " ms");
		}
	}
}
