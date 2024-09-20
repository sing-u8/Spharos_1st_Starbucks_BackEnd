package TRaMis8khae.starbucks.event.application;

import TRaMis8khae.starbucks.event.dto.EventInfoResponseDto;
import TRaMis8khae.starbucks.event.dto.EventRequestDto;
import TRaMis8khae.starbucks.event.entity.Event;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface EventService {

    List<EventInfoResponseDto> getEventList(Long eventId);
    List<String> getEventUUID(Long eventId);

    void addEvent(EventRequestDto requestDto, MultipartFile image);

    Optional<Event> getEventWithMedia(Long eventId);

    EventInfoResponseDto getEvent(Long eventId);

}
