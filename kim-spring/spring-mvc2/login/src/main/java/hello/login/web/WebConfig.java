package hello.login.web;

import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import hello.login.web.argumentresolver.LoginMemberArgumentResolver;
import hello.login.web.filter.LogFilter;
import hello.login.web.filter.LoginCheckFilter;
import hello.login.web.intercepter.LogInterceptor;
import hello.login.web.intercepter.LoginCheckInterceptor;
import jakarta.servlet.Filter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new LoginMemberArgumentResolver());
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LogInterceptor())
			.order(1) 
			.addPathPatterns("/**")
			.excludePathPatterns("/css/**", "/*.ico", "/error"); // 화이트리스트

		registry.addInterceptor(new LoginCheckInterceptor())
			.order(2)
			.addPathPatterns("/**")
			.excludePathPatterns("/", "/members/add", "/login",
				"/logout", "/css/**", "/*.ico", "/error"); // 화이트리스트
	}

	// @Bean
	public FilterRegistrationBean<Filter> logFilter() {
		FilterRegistrationBean<Filter> filterRegistrationBean
			= new FilterRegistrationBean<>();

		filterRegistrationBean.setFilter(new LogFilter());
		filterRegistrationBean.setOrder(1); // 필터 체인에서 적용될 순서
		filterRegistrationBean.addUrlPatterns("/*"); // 모든 요청에 대해

		return filterRegistrationBean;
	}

	// @Bean
	public FilterRegistrationBean<Filter> loginCheckFilter() {
		FilterRegistrationBean<Filter> filterRegistrationBean
			= new FilterRegistrationBean<>();

		filterRegistrationBean.setFilter(new LoginCheckFilter());
		filterRegistrationBean.setOrder(2); // 필터 체인에서 적용될 순서
		filterRegistrationBean.addUrlPatterns("/*"); // 모든 요청에 대해(필터에 화이트리스트 있음)

		return filterRegistrationBean;
	}
}
