package jpabook.jpashop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jpabook.jpashop.dto.ItemView;
import jpabook.jpashop.dto.MemberView;
import jpabook.jpashop.dto.OrderView;
import jpabook.jpashop.repository.OrderSearch;
import jpabook.jpashop.service.ItemService;
import jpabook.jpashop.service.MemberService;
import jpabook.jpashop.service.OrderService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;
	private final MemberService memberService;
	private final ItemService itemService;

	@GetMapping("/new")
	public String createOrderForm(Model model) {
		List<MemberView> members = memberService.findMembers();
		List<ItemView> items = itemService.findItems();

		model.addAttribute("members", members);
		model.addAttribute("items", items);

		return "order/orderForm";
	}

	@PostMapping("/new")
	public String createOrder(
		@RequestParam("memberId") Long memberId,
		@RequestParam("itemId") Long itemId,
		@RequestParam("count") int count) {

		orderService.order(memberId, itemId, count);

		return "redirect:/orders";
	}

	@GetMapping("")
	public String list(@ModelAttribute("orderSearch") OrderSearch orderSearch, Model model) {

		List<OrderView> orders = orderService.findOrders(orderSearch);
		model.addAttribute("orders", orders);

		return "order/orderList";
	}

	@PostMapping("/{orderId}/cancel")
	public String cancel(@PathVariable("orderId") Long orderId) {
		orderService.cancel(orderId);

		return "redirect:/orders";
	}
}
