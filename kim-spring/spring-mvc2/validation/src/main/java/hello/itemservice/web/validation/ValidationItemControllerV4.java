package hello.itemservice.web.validation;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import hello.itemservice.web.validation.dto.ItemSaveRequest;
import hello.itemservice.web.validation.dto.ItemUpdateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/validation/v4/items")
@RequiredArgsConstructor
public class ValidationItemControllerV4 {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "validation/v4/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "validation/v4/item";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        return "validation/v4/addForm";
    }

    @PostMapping("/add")
    public String addItem(@Validated @ModelAttribute("item") ItemSaveRequest itemSaveRequest, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        // 요구사항 반영: 가격 * 수량의 합이 10000 이상
        if (itemSaveRequest.getPrice() != null && itemSaveRequest.getQuantity() != null) {
            int result = itemSaveRequest.getPrice() * itemSaveRequest.getQuantity();

            if (result < 10000) {
                bindingResult.reject("total.price.min", new Object[] {10000, result}, null);
            }
        }

        // 검증 실패 처리
        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);

            return "validation/v4/addForm";
        }

        Item itemParam = new Item(
            itemSaveRequest.getItemName(),
            itemSaveRequest.getPrice(),
            itemSaveRequest.getQuantity()
        );

        Item savedItem = itemRepository.save(itemParam);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/validation/v4/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "validation/v3/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @Validated @ModelAttribute("item") ItemUpdateRequest itemUpdateRequest, BindingResult bindingResult) {
        // 요구사항 반영: 가격 * 수량의 합이 10000 이상
        if (itemUpdateRequest.getPrice() != null && itemUpdateRequest.getQuantity() != null) {
            int result = itemUpdateRequest.getPrice() * itemUpdateRequest.getQuantity();

            if (result < 10000) {
                bindingResult.reject("total.price.min", new Object[] {10000, result}, null);
            }
        }

        // 검증 실패 처리
        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);

            return "validation/v4/editForm";
        }

        Item itemParam = new Item(
            itemUpdateRequest.getItemName(),
            itemUpdateRequest.getPrice(),
            itemUpdateRequest.getQuantity()
        );

        itemRepository.update(itemId, itemParam);
        return "redirect:/validation/v4/items/{itemId}";
    }
}

