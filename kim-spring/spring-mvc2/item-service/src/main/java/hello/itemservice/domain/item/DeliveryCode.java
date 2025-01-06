package hello.itemservice.domain.item;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeliveryCode {

	/**
	 * FAST: 빠른 배송
	 * NORMAL: 일반 배송
	 * SLOW: 느린 배송
	 */
	private String code;

	private String displayName;

}
