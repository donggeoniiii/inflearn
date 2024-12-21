package hello.itemservice.domain.item;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ItemRepositoryTest {

	ItemRepository itemRepository = new ItemRepository();

	@AfterEach
	void tearDown() {
		itemRepository.clear();
	}

	@Test
	public void save() {
		// given
		Item item = createItem("icebear", 10000, 1);

		// when
		Item savedItem = itemRepository.save(item);

		// then
		assertThat(savedItem.getId()).isNotNull();
		assertThat(savedItem.getItemName()).isEqualTo("icebear");
		assertThat(savedItem.getPrice()).isEqualTo(10000);
		assertThat(savedItem.getQuantity()).isEqualTo(1);
	}
	
	@Test
	public void findById() {
		// given
		Item item = createItem("icebear", 10000, 1);
		Item savedItem = itemRepository.save(item);

		// when
		Item foundItem = itemRepository.findById(savedItem.getId());

		// then
		assertThat(savedItem).isEqualTo(foundItem);
	}

	@Test
	public void findAll() {
		// given
		Item item1 = createItem("icebear", 10000, 1);
		Item item2 = createItem("icebear2", 20000, 2);
		itemRepository.save(item1);
		itemRepository.save(item2);

		// when
		List<Item> items = itemRepository.findAll();

		// then
		assertThat(items).hasSize(2);
		assertThat(items).contains(item1, item2);
	}

	@Test
	public void updateItem() {
		// given
		Item oldItem = itemRepository.save(createItem("icebear", 10000, 1));
		Item newItem = createItem("icebear2", 20000, 2);

		// when
		itemRepository.update(oldItem.getId(), newItem);

		// then
		List<Item> items = itemRepository.findAll();
		assertThat(items).hasSize(1);
		assertThat(newItem.getItemName()).isEqualTo("icebear2");
		assertThat(newItem.getPrice()).isEqualTo(20000);
		assertThat(newItem.getQuantity()).isEqualTo(2);
	}

	// == 테스트용 메서드 ==
	private Item createItem(String name, int price, int quantity) {
		Item item = new Item();
		item.setItemName(name);
		item.setPrice(price);
		item.setQuantity(quantity);
		return item;
	}
}