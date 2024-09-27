package TRaMis8khae.starbucks.product.dto.out;


import TRaMis8khae.starbucks.media.entity.Media;
import TRaMis8khae.starbucks.product.entity.Product;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class EventProductResponseDto {

	private String name;

	private Double price;

	private Long productMediaId;

	private String productUUID;

	public static EventProductResponseDto toDto(Product product, Media media) {

		return EventProductResponseDto.builder()
			.name(product.getProductName())
			.productMediaId(media.getId())
			.price(product.getPrice())
			.productUUID(product.getProductUUID())
			.build();
	}
}
