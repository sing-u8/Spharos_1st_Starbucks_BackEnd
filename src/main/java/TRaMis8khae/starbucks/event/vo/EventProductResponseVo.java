package TRaMis8khae.starbucks.event.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class EventProductResponseVo {

    private String productName;

    private Integer discountRate;

    private Integer price;

}
