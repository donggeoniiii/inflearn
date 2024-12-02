package jpabook.jpashop.domain.item;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype") // 기본값이 DTYPE
@Getter @Setter
public abstract class Item {

	@Id @GeneratedValue
	@Column(name = "item_id")
	private Long id;

	private String name;

	private int price;

	private int stock;

	@ManyToMany(mappedBy = "items")
	private List<Category> categories = new ArrayList<>();
}
