package hello.core.discount;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

class RateDiscountPolicyTest {
	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

	@Test
	@DisplayName("VIP는 10% 할인이 적용된다")
	void getDiscount() {
		// given
		Member member = new Member(1L, "동건", Grade.VIP);

		// when
		int discountPrice = discountPolicy.getDiscount(member, 10000);

		// then
		assertThat(discountPrice).isEqualTo(1000);
	}

	@Test
	@DisplayName("일반 회원은 할인이 적용되지 않는다")
	void getNoDiscountToBasic() {
		// given
		Member member = new Member(1L, "동건", Grade.BASIC);

		// when
		int discountPrice = discountPolicy.getDiscount(member, 10000);

		// then
		assertThat(discountPrice).isEqualTo(0);
	}
}