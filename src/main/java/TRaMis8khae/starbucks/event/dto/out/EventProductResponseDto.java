package TRaMis8khae.starbucks.event.dto.out;

import TRaMis8khae.starbucks.event.entity.EventMedia;
import TRaMis8khae.starbucks.event.vo.out.EventProductResponseVo;
import TRaMis8khae.starbucks.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class EventProductResponseDto {

    private String productName;
    private Integer price;
    private String media;

    public static EventProductResponseDto toDto(Product product, String eventMedia) {
        return EventProductResponseDto.builder()
                .productName(product.getProductName())
                .price(product.getPrice().intValue())
                .media(eventMedia)
                .build();
    }

    public static EventProductResponseVo toVo(EventProductResponseDto responseDto) {
        return EventProductResponseVo.builder()
                .productName(responseDto.getProductName())
                .price(responseDto.getPrice())
                .media(responseDto.getMedia())
                .build();
    }

}
