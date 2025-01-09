package hello.itemservice.web.validation.dto;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ItemUpdateRequest {

	@NotNull
	private Long id;

	@NotBlank
	private String itemName;

	@NotNull
	@Range(min = 1000, max = 1_000_000)
	private Integer price;

	@NotNull
	@Min(1)
	private Integer quantity;

}
