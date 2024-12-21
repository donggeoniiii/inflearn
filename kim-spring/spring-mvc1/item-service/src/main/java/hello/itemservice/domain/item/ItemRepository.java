package hello.itemservice.domain.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {

	private static final Map<Long, Item> store = new HashMap<>();
	private static long sequence = 0L;

	public Item save(Item item) {
		item.setId(++sequence);
		store.put(item.getId(), item);

		return item;
	}

	public Item findById(Long id) {
		return store.get(id);
	}

	public List<Item> findAll() {
		return new ArrayList<>(store.values());
	}

	public void update(Long id, Item newItem) {
		Item oldItem = store.get(id);

		oldItem.setItemName(newItem.getItemName());
		oldItem.setPrice(newItem.getPrice());
		oldItem.setQuantity(newItem.getQuantity());
	}

	public void clear() {
		store.clear();
	}
}
