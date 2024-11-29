package jpabook.jpashop.domain;

import static jakarta.persistence.FetchType.*;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Category {

	@Id @GeneratedValue
	@Column(name = "category_id")
	private Long id;

	private String name;

	@ManyToMany // 딱 중간테이블만 생기고, 필드 추가가 안돼서 실무에선 사용하기 어려움
	@JoinTable(
		name = "category_item",
		joinColumns = @JoinColumn(name = "category_id"),
		inverseJoinColumns = @JoinColumn(name = "item_id")
	) // 다대다 관계는 중간 테이블 필요
	private List<Item> items = new ArrayList<>();

	// 카테고리의 계층 구조를 위한 셀프 양방향 매핑
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "parent_id")
	private Category parent;

	@OneToMany(mappedBy = "parent")
	private List<Category> child = new ArrayList<>();

	// == 연관관계 메서드 == //
	public void addChildCategory(Category child) {
		parent.getChild().add(child);
		child.setParent(this);
	}
}
