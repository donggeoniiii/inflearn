package jpabook.jpashop.dto;

import jpabook.jpashop.domain.Address;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberView {
	private Long id;

	private String name;

	private Address address;
}
