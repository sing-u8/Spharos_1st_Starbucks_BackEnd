package TRaMis8khae.starbucks.event.dto.in;

import TRaMis8khae.starbucks.event.entity.EventMedia;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EventMediaRequestDto {

    private String eventId;

    private Long mediaId;

    public EventMedia toEntity() {
        return EventMedia.builder()
                .eventId(eventId)
                .mediaId(mediaId)
                .build();
    }

}
