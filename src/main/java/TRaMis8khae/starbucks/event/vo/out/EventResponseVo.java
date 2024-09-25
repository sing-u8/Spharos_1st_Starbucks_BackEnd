package TRaMis8khae.starbucks.event.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@ToString
public class EventResponseVo {

    private String eventName;

    private Integer discountRate;

    private LocalDate startDate;

    private LocalDate endDate;

    private List<String> mediaPath;

}
