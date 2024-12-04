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
import jpabook.jpashop.dto.ItemView;
import jpabook.jpashop.exception.NotEnoughStockException;
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

	/**
	 * 상품 재고 수정
	 * @param quantity 변경 재고량
	 */
	public void updateStock(int quantity) {
		stock = quantity;
	}

	/**
	 * 상품 가격 수정
	 */
	public void updatePrice(int price) {
		this.price = price;
	}

	// == to Dto == //
	public ItemView toView() {
		ItemView itemView = new ItemView();
		itemView.setId(id);
		itemView.setName(name);
		itemView.setPrice(price);
		itemView.setStock(stock);

		return itemView;
	}
}
