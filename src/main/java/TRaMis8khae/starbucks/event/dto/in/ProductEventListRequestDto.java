package TRaMis8khae.starbucks.event.dto.in;

import TRaMis8khae.starbucks.event.entity.Event;
import TRaMis8khae.starbucks.event.entity.ProductEventList;
import TRaMis8khae.starbucks.event.vo.in.ProductEventListRequestVo;
import TRaMis8khae.starbucks.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class ProductEventListRequestDto {

    private Event event;

    private Product product;

    public static ProductEventListRequestDto toDto(Event event, Product product) {
        return ProductEventListRequestDto.builder()
                .event(event)
                .product(product)
                .build();
    }

    public ProductEventList toEntity(Event event, Product product) {
        return ProductEventList.builder()
                .event(event)
                .product(product)
                .build();
    }

}
