package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FIxDiscountPolicy implements DiscountPolicy {
	private final int discountPrice = 1000;

	@Override
	public int getDiscount(Member member, int price) {
		if (member.getGrade() == Grade.VIP)
			return discountPrice;
		return 0;
	}
}
