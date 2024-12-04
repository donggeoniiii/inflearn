package jpabook.jpashop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.dto.BookForm;
import jpabook.jpashop.dto.ItemView;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

	private final ItemRepository itemRepository;

	@Transactional
	public void saveItem(BookForm bookForm) {

		Book book = Book.createBook(bookForm);

		itemRepository.save(book);
	}

	public List<ItemView> findItems() {
		return itemRepository.findAll().stream()
			.map(Item::toView)
			.collect(Collectors.toList());
	}

	public ItemView findOne(Long itemId) {
		return itemRepository.findOne(itemId).toView();
	}

	public BookForm getUpdateForm(Long itemId) {
		return ((Book) itemRepository.findOne(itemId)).toForm();
	}

	@Transactional
	public void updateItem(Long itemId, BookForm bookForm) {
		Item item = itemRepository.findOne(itemId);

		item.updatePrice(bookForm.getPrice());
		item.updateStock(bookForm.getStock());
	}
}
