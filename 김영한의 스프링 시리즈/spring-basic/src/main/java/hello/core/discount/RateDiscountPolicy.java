package hello.core.discount;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;

@Component
// @Qualifier("mainDiscountPolicy") // 추가 구분자 역할, 근데 빈이 중복될 때 찾는 용도보단 Qualifier 자체로 사용되는 용도로 쓰자
@Primary // 동일 이름의 빈이 여러 개일 때 우선권 표시, Qualifier 있을 시엔 Qualifier 먼저
@MainDiscountPolicy // 커스텀 어노테이션
public class RateDiscountPolicy implements DiscountPolicy {
	private final int discountPercent = 10;

	@Override
	public int getDiscount(Member member, int price) {
		if (member.getGrade() == Grade.VIP)
			return price * discountPercent / 100;
		return 0;
	}
}
