package hello.core.discount;

import org.springframework.stereotype.Component;

import hello.core.member.Grade;
import hello.core.member.Member;

@Component
public class FixDiscountPolicy implements DiscountPolicy {
	private final int discountPrice = 1000;

	@Override
	public int getDiscount(Member member, int price) {
		if (member.getGrade() == Grade.VIP)
			return discountPrice;
		return 0;
	}
}
