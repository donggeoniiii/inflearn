package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable // 내장 값 타입
@Getter // 값이 변경되면 안됨! setter 대신 생성자 제공해서 새 객체를 반환하도록 유도하는 불변객체로 쓰자
public class Address {

	private String city;

	private String street;

	private String zipcode;

	protected Address() {} // jpa 스펙 상 생성하는 기본 생성자

	public Address(String city, String street, String zipcode) {
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}
}
