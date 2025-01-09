package hello.itemservice.web.validation.dto;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ItemSaveRequest {

	@NotBlank
	private String itemName;

	@NotNull
	@Range(min = 1000, max = 1_000_000)
	private Integer price;

	@NotNull
	@Min(1)
	@Max(9999)
	private Integer quantity;
}
