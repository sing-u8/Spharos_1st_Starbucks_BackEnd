package TRaMis8khae.starbucks.event.dto.out;

import TRaMis8khae.starbucks.event.vo.out.EventProductResponseVo;
import TRaMis8khae.starbucks.product.entity.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EventProductResponseDto {

    private String productName;
    private Integer discountRate;
    private Integer price;

    public static EventProductResponseDto toDto(Product product) {
        return EventProductResponseDto.builder()
                .productName(product.getProductName())
                .price(product.getPrice().intValue())
                .build();
    }

    public static EventProductResponseVo toVo(EventProductResponseDto responseDto) {
        return EventProductResponseVo.builder()
                .productName(responseDto.getProductName())
                .build();
    }

}
