package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
	/**
	 * @return 할인 금액
	 */
	int getDiscount(Member member, int price);
}
