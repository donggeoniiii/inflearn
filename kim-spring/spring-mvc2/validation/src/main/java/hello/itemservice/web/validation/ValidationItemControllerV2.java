package hello.itemservice.web.validation;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/validation/v2/items")
@RequiredArgsConstructor
public class ValidationItemControllerV2 {

    private final ItemRepository itemRepository;

    private final ItemValidator itemValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        log.info("init binder {}", dataBinder);
        dataBinder.addValidators(itemValidator);
    }

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "validation/v2/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "validation/v2/item";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        return "validation/v2/addForm";
    }

    // @PostMapping("/add")
    public String addItemV1(@ModelAttribute Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        // 상품 이름 없음
        if (!StringUtils.hasText(item.getItemName())) {
            bindingResult.addError(new FieldError("item", "itemName", "상품 이름은 필수입니다."));
        }

        // 비정상적 상품 가격
        if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1_000_000) {
            bindingResult.addError(new FieldError("item", "price", "가격 범위는 1,000원 이상 1,000,000원 이하여야 합니다."));
        }

        // 비정상적인 상품 수량
        if (item.getQuantity() == null || item.getQuantity() < 0 || item.getQuantity() >= 9999) {
            bindingResult.addError(new FieldError("item", "quantity", "수량은 1개부터 9,999개까지 지원합니다."));
        }

        // 요구사항 반영: 가격 * 수량의 합이 10000 이상
        if (item.getPrice() != null && item.getQuantity() != null) {
            int result = item.getPrice() * item.getQuantity();

            // 특정 단일 입력폼의 문제가 아니므로 ObjectError 처리
            if (result < 10000) {
                bindingResult.addError(new ObjectError("item", "가격 * 수량의 합은 10,000원 이상이어야 합니다. 현재 값 = " + result));
            }
        }

        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);

            return "validation/v2/addForm";
        }

        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/validation/v2/items/{itemId}";
    }

    // @PostMapping("/add")
    public String addItemV2(@ModelAttribute Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        // 상품 이름 없음
        if (!StringUtils.hasText(item.getItemName())) {
            /*
                rejectedValue: 사용자가 입력했으나 거절된 값
                bindingFailure: 객체에 바인딩 할 수 없는 타입 에러인지 구분(이러면 객체 값 저장 안되니까)
                codes, arguments: 스프링 메시지를 위해 이용, 프로퍼티 파일 설정
             */
            bindingResult.addError(new FieldError("item", "itemName", item.getItemName(), false, null, null, "상품 이름은 필수입니다."));
        }

        // 비정상적 상품 가격
        if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1_000_000) {
            bindingResult.addError(new FieldError("item", "price", item.getPrice(), false, null,  null, "가격 범위는 1,000원 이상 1,000,000원 이하여야 합니다."));
        }

        // 비정상적인 상품 수량
        if (item.getQuantity() == null || item.getQuantity() < 0 || item.getQuantity() >= 9999) {
            bindingResult.addError(new FieldError("item", "quantity", item.getQuantity(), false, null, null, "수량은 1개부터 9,999개까지 지원합니다."));
        }

        // 요구사항 반영: 가격 * 수량의 합이 10000 이상
        if (item.getPrice() != null && item.getQuantity() != null) {
            int result = item.getPrice() * item.getQuantity();

            // 특정 단일 입력폼의 문제가 아니므로 ObjectError 처리
            if (result < 10000) {
                bindingResult.addError(new ObjectError("item", "가격 * 수량의 합은 10,000원 이상이어야 합니다. 현재 값 = " + result));
            }
        }

        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);

            return "validation/v2/addForm";
        }

        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/validation/v2/items/{itemId}";
    }

    // @PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        // 상품 이름 없음
        if (!StringUtils.hasText(item.getItemName())) {
            bindingResult.addError(new FieldError("item", "itemName", item.getItemName(), false, new String[]{"required.item.itemName"}, null, null));
        }

        // 비정상적 상품 가격
        if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1_000_000) {
            bindingResult.addError(new FieldError("item", "price", item.getPrice(), false, new String[]{"range.item.price"},  new Object[]{1000, 1_000_000}, null));
        }

        // 비정상적인 상품 수량
        if (item.getQuantity() == null || item.getQuantity() < 0 || item.getQuantity() >= 9999) {
            bindingResult.addError(new FieldError("item", "quantity", item.getQuantity(), false, new String[]{"max.item.quantity"}, new Object[]{9999}, null));
        }

        // 요구사항 반영: 가격 * 수량의 합이 10000 이상
        if (item.getPrice() != null && item.getQuantity() != null) {
            int result = item.getPrice() * item.getQuantity();

            // 특정 단일 입력폼의 문제가 아니므로 ObjectError 처리
            if (result < 10000) {
                bindingResult.addError(new ObjectError("item", new String[]{"total.price.min"}, new Object[]{10000, result}, null));
            }
        }

        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);

            return "validation/v2/addForm";
        }

        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/validation/v2/items/{itemId}";
    }

    // 파라미터 상 model attribute 바로 다음에 온다 -> 사실 bindingResult는 검증해야 할 객체가 무엇인지 알고 있다.
    // @PostMapping("/add")
    public String addItemV4(@ModelAttribute Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        // 상품 이름 없음
        if (!StringUtils.hasText(item.getItemName())) {
            bindingResult.rejectValue("itemName", "required");
        }

        // 비정상적 상품 가격
        if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1_000_000) {
            bindingResult.rejectValue("price", "range", new Object[] {1000, 1_000_000}, null);
        }

        // 비정상적인 상품 수량
        if (item.getQuantity() == null || item.getQuantity() < 0 || item.getQuantity() >= 9999) {
            bindingResult.rejectValue("quantity", "max", new Object[] {9999}, null);
        }

        // 요구사항 반영: 가격 * 수량의 합이 10000 이상
        if (item.getPrice() != null && item.getQuantity() != null) {
            int result = item.getPrice() * item.getQuantity();

            if (result < 10000) {
                bindingResult.reject("total.price.min", new Object[] {10000, result}, null);
            }
        }

        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);

            return "validation/v2/addForm";
        }

        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/validation/v2/items/{itemId}";
    }

    // @PostMapping("/add")
    public String addItemV5(@ModelAttribute Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        itemValidator.validate(item, bindingResult);

        // 검증 실패 처리
        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);

            return "validation/v2/addForm";
        }

        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/validation/v2/items/{itemId}";
    }

    // @Validated : 데이터 바인더에 등록된 validator 구현체 자동으로 적용
    @PostMapping("/add")
    public String addItemV6(@Validated @ModelAttribute Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        // 검증 실패 처리
        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);

            return "validation/v2/addForm";
        }

        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/validation/v2/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "validation/v2/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @Validated @ModelAttribute Item item, BindingResult bindingResult) {
        // 검증 실패 처리
        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);

            return "validation/v2/editForm";
        }

        itemRepository.update(itemId, item);
        return "redirect:/validation/v2/items/{itemId}";
    }

}

