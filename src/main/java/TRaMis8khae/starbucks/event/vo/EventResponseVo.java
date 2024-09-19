package TRaMis8khae.starbucks.event.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
public class EventResponseVo {

    private String eventName;

    private Integer discountRate;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

}
