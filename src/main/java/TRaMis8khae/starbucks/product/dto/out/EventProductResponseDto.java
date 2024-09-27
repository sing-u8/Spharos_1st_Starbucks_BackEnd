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

	private String productUUID;

	private Long productId;

	private Long productMediaId;


	public static EventProductResponseDto toDto(Product product, Media media) {

		return EventProductResponseDto.builder()
			.name(product.getProductName())
			.productMediaId(media.getId())
			.price(product.getPrice())
			.productUUID(product.getProductUUID())
			.productId(product.getId())
			.build();
	}

	public EventProductResponseDto toVo(EventProductResponseDto responseDto) {
		return EventProductResponseDto.builder()
				.name(responseDto.getName())
				.productMediaId(responseDto.getProductMediaId())
				.price(responseDto.getPrice())
				.productUUID(responseDto.getProductUUID())
				.productId(responseDto.getProductId())
				.build();
	}
}
