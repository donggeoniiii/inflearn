package jpabook.jpashop.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B") // 싱글테이블 전략 시 저장할 때의 식별값
@Getter @Setter
public class Book extends Item {

	private String author;

	private String isbn;
}
