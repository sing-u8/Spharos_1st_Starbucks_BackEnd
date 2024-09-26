package TRaMis8khae.starbucks.event.dto.in;

import TRaMis8khae.starbucks.event.entity.Event;
import TRaMis8khae.starbucks.event.entity.EventMedia;
import lombok.Builder;
import lombok.Getter;

import static TRaMis8khae.starbucks.event.entity.QEvent.event;

@Getter
@Builder
public class EventMediaRequestDto {

    private Event event;

    private Long mediaId;

    public EventMedia toEntity() {
        return EventMedia.builder()
                .event(event)
                .mediaId(mediaId)
                .build();
    }

}
