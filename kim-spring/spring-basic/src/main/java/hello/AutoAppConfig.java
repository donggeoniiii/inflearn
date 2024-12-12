package hello;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
	// appConfig 등 이외 다른 설정 파일 제외하고 컴포넌트 스캔(배우는 중이니깐)
	excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)

	// 탐색할 패키지의 시작 위치, 기본값은 설정 파일의 위치(여기선 hello)
	// 어지간해서는 그냥 최상단에 설정 파일이 있는게 낫다(프로젝트 대표 정보기도 하니까)
	// , basePackages = {"hello.core.member", "hello.service"}

	// 지정한 클래스가 있는 위치를 스캔 최상단 위치로 설정
	// , basePackageClasses = {AutoAppConfig.class, AppConfig.class}
)
public class AutoAppConfig {
	// 비워놔도 됨! 자동으로 bean 등록

	// 고의충돌 시 수동 충돌 bean이 우선권을 가짐(로그 보면 알 수 있음)
	// 스프링부트는 오류가 남
	// @Bean(name = "memoryMemberRepository")
	// public MemberRepository memberRepository() {
	// 	return new MemoryMemberRepository();
	// }
}
