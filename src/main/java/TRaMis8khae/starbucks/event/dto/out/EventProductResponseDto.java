package TRaMis8khae.starbucks.event.dto.out;

import TRaMis8khae.starbucks.event.vo.out.EventProductResponseVo;
import TRaMis8khae.starbucks.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class EventProductResponseDto {

    private String productName;
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
                .price(responseDto.getPrice())
                .build();
    }

}
