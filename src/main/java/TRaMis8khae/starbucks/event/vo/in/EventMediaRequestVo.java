package TRaMis8khae.starbucks.event.vo.in;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EventMediaRequestVo {

    private String eventId;

    private Long mediaId;

}
