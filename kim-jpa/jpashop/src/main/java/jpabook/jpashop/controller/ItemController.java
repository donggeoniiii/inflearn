package jpabook.jpashop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jpabook.jpashop.dto.BookForm;
import jpabook.jpashop.dto.ItemView;
import jpabook.jpashop.service.ItemService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

	private final ItemService itemService;

	/**
	 * 상품 등록 폼
	 */
	@GetMapping("/new")
	public String createItemForm(Model model) {
		model.addAttribute("form", new BookForm());
		return "items/createItemForm";
	}

	/**
	 * 상품 등록
	 */
	@PostMapping("/new")
	public String createItem(BookForm bookForm) {
		itemService.saveItem(bookForm);
		return "redirect:/";
	}

	/**
	 * 상품 목록 조회
	 */
	@GetMapping("")
	public String list(Model model) {
		List<ItemView> items = itemService.findItems();
		model.addAttribute("items", items);

		return "items/itemList";
	}

	/**
	 * 상품 정보 수정 폼
	 */
	@GetMapping("/{itemId}/edit")
	public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {
		BookForm bookForm = itemService.getUpdateForm(itemId);

		model.addAttribute("form", bookForm);
		return "items/updateItemForm";
	}

	/**
	 * 상품 정보 수정
	 */
	@PostMapping("/{itemId}/edit")
	public String updateItem(@PathVariable Long itemId, @ModelAttribute("form") BookForm bookForm) {
		// id를 다루는 메서드가 있는 경우, 해당 데이터에 대한 권한을 체크하는 로직이 앞단이든 뒷단이든 있어야 한다
		/*
			Book book = Book.createBook(bookForm); (x)
			컨트롤러 단에서 엔티티 생성하지 말자!!
			jpa가 관리하는 트랜잭션이 걸려 있는 서비스 단에서 처리하는게 옳다(변경 감지 적극 사용)
		*/
		itemService.updateItem(itemId, bookForm);

		return "redirect:/items";
	}
}
