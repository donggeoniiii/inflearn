package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jpabook.jpashop.dto.MemberForm;
import jpabook.jpashop.dto.MemberView;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter // setter는 편의상 열어놓은 것. 실무에선 쓰지 말도록 하자
public class Member {
	@Id @GeneratedValue
	@Column(name = "member_id")
	private Long id; // memberId 이런 식으로 만들어도 된다. 일관성 있게만 한다면 상관 x

	private String name;

	@Embedded // embeddable 어노테이션을 붙이면 안해도 되지만 둘다 쓰는 편
	private Address address;

	// mappedBy 설정을 통해 order에 있는 member 필드의 거울임을 표시
	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<>(); // 컬렉션은 필드에서 초기화하는게 베스트 프랙티스

	// == 생성 메서드 == //
	public static Member createMember(MemberForm memberForm) {
		Member member = new Member();
		member.setName(memberForm.getName());

		Address address = new Address(memberForm.getCity(), memberForm.getStreet(), memberForm.getZipcode());
		member.setAddress(address);

		return member;
	}

	// == to dto == //
	public MemberView toView() {
		MemberView memberView = new MemberView();
		memberView.setId(id);
		memberView.setName(name);
		memberView.setAddress(address);
		return memberView;
	}
}
