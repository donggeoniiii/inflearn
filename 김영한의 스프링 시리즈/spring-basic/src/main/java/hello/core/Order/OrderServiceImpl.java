package hello.core.Order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FIxDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository = new MemoryMemberRepository();
	private final DiscountPolicy discountPolicy = new FIxDiscountPolicy();

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.getDiscount(member, itemPrice);

		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
}
