package TRaMis8khae.starbucks.event.dto;

import TRaMis8khae.starbucks.event.vo.EventProductResponseVo;
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

    public EventProductResponseVo toVo() {
        return EventProductResponseVo.builder()
                .productName(this.productName)
                .discountRate(this.discountRate)
                .price(this.price)
                .build();
    }

}
