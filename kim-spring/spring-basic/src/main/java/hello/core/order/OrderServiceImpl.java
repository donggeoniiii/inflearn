package hello.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

@Component
// @RequiredArgsConstructor // lombok + 생성자 주입 + 생성자 하나일 시 autowired 생략 연계
public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;

	/* 
		생성자 주입: 딱 한번 호출이 보장됨 / 불변, 필수 의존관계에 주로 사용.
		생성자가 하나면 어노테이션 없어도 됨!
		인스턴스를 갈아낄 일이 있을 때 setter 주입 정도는 사용
		필드 주입, 일반 메서드로 의존관계 주입도 가능은 하지만 비추
		애초에 의존관계는 실행 이후 변경될 일이 없는게 맞다. 그냥 생성자 주입 쓰자
	 */

	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.getDiscount(member, itemPrice);

		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
}
