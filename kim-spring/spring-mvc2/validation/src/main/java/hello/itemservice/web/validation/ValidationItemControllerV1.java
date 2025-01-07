package hello.itemservice.web.validation;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/validation/v1/items")
@RequiredArgsConstructor
public class ValidationItemControllerV1 {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "validation/v1/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "validation/v1/item";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        return "validation/v1/addForm";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute Item item, Model model, RedirectAttributes redirectAttributes) {

        // 검증 오류 결과
        Map<String, String> errors = new HashMap<>();

        // 상품 이름 없음
        if (!StringUtils.hasText(item.getItemName())) {
            errors.put("itemName", "상품 이름은 필수입니다.");
        }

        // 비정상적 상품 가격
        if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1_000_000) {
            errors.put("price", "가격 범위는 1,000원 이상 1,000,000원 이하여야 합니다.");
        }

        // 비정상적인 상품 수량
        if (item.getQuantity() == null || item.getQuantity() < 0 || item.getQuantity() >= 9999) {
            errors.put("quantity", "수량은 1개부터 9,999개까지 지원합니다.");
        }

        // 요구사항 반영: 가격 * 수량의 합이 10000 이상
        if (item.getPrice() != null && item.getQuantity() != null) {
            int result = item.getPrice() * item.getQuantity();

            if (result < 10000) {
                errors.put("globalError", "가격 * 수량의 합은 10,000원 이상이어야 합니다. 현재 값 = " + result);
            }
        }

        if (hasError(errors)) {
            log.info("errors = {}", errors);
            model.addAttribute("errors", errors);

            return "validation/v1/addForm";
        }

        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/validation/v1/items/{itemId}";
    }

    private static boolean hasError(Map<String, String> errors) {
        return !errors.isEmpty();
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "validation/v1/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item, Model model) {
        // 검증 오류 결과
        Map<String, String> errors = new HashMap<>();

        // 상품 이름 없음
        if (!StringUtils.hasText(item.getItemName())) {
            errors.put("itemName", "상품 이름은 필수입니다.");
        }

        // 비정상적 상품 가격
        if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1_000_000) {
            errors.put("price", "가격 범위는 1,000원 이상 1,000,000원 이하여야 합니다.");
        }

        // 비정상적인 상품 수량
        if (item.getQuantity() == null || item.getQuantity() < 0 || item.getQuantity() >= 9999) {
            errors.put("quantity", "수량은 1개부터 9,999개까지 지원합니다.");
        }

        // 요구사항 반영: 가격 * 수량의 합이 10000 이상
        if (item.getPrice() != null && item.getQuantity() != null) {
            int result = item.getPrice() * item.getQuantity();

            if (result < 10000) {
                errors.put("globalError", "가격 * 수량의 합은 10,000원 이상이어야 합니다. 현재 값 = " + result);
            }
        }

        if (hasError(errors)) {
            log.info("errors = {}", errors);
            model.addAttribute("errors", errors);

            return "validation/v1/editForm";
        }

        itemRepository.update(itemId, item);
        return "redirect:/validation/v1/items/{itemId}";
    }

}

