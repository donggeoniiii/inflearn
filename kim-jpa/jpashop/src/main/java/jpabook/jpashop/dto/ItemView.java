package jpabook.jpashop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemView {
	private Long id;

	private String name;
	private int price;
	private int stock;


}
