package hello.itemservice.domain.item;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;

@Getter
public class ItemAttribute {

	private final Map<String, String> regions;

	private final List<DeliveryCode> deliveryCodes;

	private final ItemType[] itemTypes;

	@Getter
	private static final ItemAttribute instance = new ItemAttribute();

	private ItemAttribute() {
		// 순서 보장을 위해 linkedHashMap 사용
		regions = new LinkedHashMap<>();
		regions.put("SEOUL", "서울");
		regions.put("BUSAN", "부산");
		regions.put("JEJU", "제주");

		deliveryCodes = new ArrayList<>();
		deliveryCodes.add(new DeliveryCode("FAST", "빠른 배송"));
		deliveryCodes.add(new DeliveryCode("NORMAL", "일반 배송"));
		deliveryCodes.add(new DeliveryCode("SLOW", "느린 배송"));

		itemTypes = ItemType.values();
	}
}
