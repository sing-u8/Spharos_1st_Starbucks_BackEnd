package TRaMis8khae.starbucks.event.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@ToString
public class EventProductResponseVo {

    private String productName;

    private Integer price;

    private String media;

}
