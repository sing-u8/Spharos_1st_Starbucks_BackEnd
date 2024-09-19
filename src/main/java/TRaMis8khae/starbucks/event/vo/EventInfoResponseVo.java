package TRaMis8khae.starbucks.event.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class EventInfoResponseVo {

    private String eventName;

    private Integer discountRate;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

}
