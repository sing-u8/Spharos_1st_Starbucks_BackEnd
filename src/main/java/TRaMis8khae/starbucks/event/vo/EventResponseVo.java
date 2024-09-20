package TRaMis8khae.starbucks.event.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class EventResponseVo {

    private String eventName;

    private Integer discountRate;

    private LocalDate startDate;

    private LocalDate endDate;

}
