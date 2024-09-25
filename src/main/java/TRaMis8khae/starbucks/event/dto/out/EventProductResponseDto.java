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
    private String description; // 상품 코드완성 시 썸네일을 불러오도록 수정

    public static EventProductResponseDto toDto(Product product) {
        return EventProductResponseDto.builder()
                .productName(product.getProductName())
                .price(product.getPrice().intValue())
                .description(product.getDescription())
                .build();
    }

    public static EventProductResponseVo toVo(EventProductResponseDto responseDto) {
        return EventProductResponseVo.builder()
                .discountRate(responseDto.getDiscountRate())
                .productName(responseDto.getProductName())
                .price(responseDto.getPrice())
                .description(responseDto.getDescription())
                .build();
    }

}
