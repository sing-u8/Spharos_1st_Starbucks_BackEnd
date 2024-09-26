package TRaMis8khae.starbucks.event.dto.in;

import TRaMis8khae.starbucks.event.entity.ProductEventList;
import TRaMis8khae.starbucks.event.vo.in.ProductEventListRequestVo;
import jdk.jfr.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class ProductEventListRequestDto {

    private Long eventId;

    private Long productId;

    public static ProductEventListRequestDto toDto(ProductEventListRequestVo requestVo) {
        return ProductEventListRequestDto.builder()
                .eventId(requestVo.getEventId())
                .productId(requestVo.getProductId())
                .build();
    }

//    public ProductEventList toEntity(Event event) {
//        return ProductEventList.builder()
//                .event(event)
//                .product()
//                .build();
//    }

}
