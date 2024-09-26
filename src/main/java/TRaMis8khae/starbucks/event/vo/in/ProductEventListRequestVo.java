package TRaMis8khae.starbucks.event.vo.in;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ProductEventListRequestVo {

    private Long eventId;

    private Long productId;

}
