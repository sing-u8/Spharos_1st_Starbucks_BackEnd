package TRaMis8khae.starbucks.event.application;

import TRaMis8khae.starbucks.event.dto.out.EventInfoResponseDto;
import TRaMis8khae.starbucks.event.dto.in.EventRequestDto;
import TRaMis8khae.starbucks.event.entity.Event;
import TRaMis8khae.starbucks.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface EventService {

    List<EventInfoResponseDto> getEventList(Long eventId);
    List<String> getProductUUID(Long eventId);

    void addEvent(EventRequestDto requestDto);
    void deleteEvent(Long eventId);

    EventInfoResponseDto getEvent(Long eventId);

}
