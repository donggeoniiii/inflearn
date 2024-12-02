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
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype") // 기본값이 DTYPE
@Getter
public abstract class Item {

	@Id @GeneratedValue
	@Column(name = "item_id")
	private Long id;

	private String name;

	private int price;

	private int stock;

	@ManyToMany(mappedBy = "items")
	private List<Category> categories = new ArrayList<>();

	// == 비즈니스 로직 == //

	/**
	 * 수량 증가
	 * @param quantity 증가량
	 */
	public void addStock(int quantity) {
		this.stock += quantity;
	}

	/**
	 * 수량 감소
	 * @param quantity 감소량
	 */
	public void removeStock(int quantity) {
		int restStock = this.stock - quantity;
		if (restStock < 0) {
			throw new NotEnoughStockException("재고 없음");
		}
		this.stock -= quantity;
	}
}
