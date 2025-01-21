package hello.login.web;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.login.web.filter.LogFilter;
import hello.login.web.filter.LoginCheckFilter;
import jakarta.servlet.Filter;

@Configuration
public class WebConfig {

	@Bean
	public FilterRegistrationBean<Filter> logFilter() {
		FilterRegistrationBean<Filter> filterRegistrationBean
			= new FilterRegistrationBean<>();

		filterRegistrationBean.setFilter(new LogFilter());
		filterRegistrationBean.setOrder(1); // 필터 체인에서 적용될 순서
		filterRegistrationBean.addUrlPatterns("/*"); // 모든 요청에 대해

		return filterRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean<Filter> loginCheckFilter() {
		FilterRegistrationBean<Filter> filterRegistrationBean
			= new FilterRegistrationBean<>();

		filterRegistrationBean.setFilter(new LoginCheckFilter());
		filterRegistrationBean.setOrder(2); // 필터 체인에서 적용될 순서
		filterRegistrationBean.addUrlPatterns("/*"); // 모든 요청에 대해(필터에 화이트리스트 있음)

		return filterRegistrationBean;
	}
}
