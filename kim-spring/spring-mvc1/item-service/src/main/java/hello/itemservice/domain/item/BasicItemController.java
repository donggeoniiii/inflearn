package hello.itemservice.domain.item;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

	private final ItemRepository itemRepository;

	@GetMapping("/{itemId}")
	public String item(@PathVariable Long itemId, Model model) {
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);

		return "basic/item";
	}

	@GetMapping("")
	public String items(Model model) {
		List<Item> items = itemRepository.findAll();
		model.addAttribute("items", items);

		return "basic/items";
	}

	@GetMapping("/add")
	public String addForm() {
		return "basic/addForm";
	}

	@GetMapping("/{itemId}/edit")
	public String editForm(@PathVariable Long itemId, Model model) {
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);

		return "basic/editForm";
	}

	@PostMapping("/add")
	public String addItem(Item item, RedirectAttributes redirectAttributes) {
		itemRepository.save(item);

		// return "basic/item";

		/*
		 PRG: 등록(POST) 후 새로고침(GET)으로 인한 중복 등록 방지를 위한 리다이렉트(Redirect)
		 redirectAttributes: url 인코딩, pathVariable 지원, 쿼리 파라미터 처리 기능
		 */
		redirectAttributes.addAttribute("itemId", item.getId());
		redirectAttributes.addAttribute("status", true);

		return "redirect:/basic/items/{itemId}";
	}

	// 수정 요청이지만, html form 방식은 GET/POST 요청만 지원함
	@PostMapping("/{itemId}/edit")
	public String editItem(@PathVariable Long itemId, Item item) {
		itemRepository.update(itemId, item);

		// @PathVariable 변수 그대로 사용 가능
		return "redirect:/basic/items/{itemId}";
	}
}
