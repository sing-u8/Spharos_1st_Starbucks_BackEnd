package TRaMis8khae.starbucks.event.vo;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Builder
@ToString
public class EventRequestVo {

    private String eventName;

    private Integer discountRate;

    private LocalDate startDate;

    private LocalDate endDate;

}
