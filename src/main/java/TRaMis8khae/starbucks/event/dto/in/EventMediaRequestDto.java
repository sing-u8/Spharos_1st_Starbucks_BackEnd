package TRaMis8khae.starbucks.event.dto.in;

import TRaMis8khae.starbucks.event.entity.Event;
import TRaMis8khae.starbucks.event.entity.EventMedia;
import lombok.Builder;
import lombok.Getter;

import static TRaMis8khae.starbucks.event.entity.QEvent.event;

@Getter
@Builder
public class EventMediaRequestDto {

    private Long eventId;

    private Long mediaId;

    public static EventMediaRequestDto toDto(Long eventId, Long mediaId) {
        return EventMediaRequestDto.builder()
                .eventId(eventId)
                .mediaId(mediaId)
                .build();
    }

    public EventMedia toEntity(EventMediaRequestDto requestDto) {
        return EventMedia.builder()
                .eventId(requestDto.getEventId())
                .mediaId(requestDto.getMediaId())
                .build();
    }

}
