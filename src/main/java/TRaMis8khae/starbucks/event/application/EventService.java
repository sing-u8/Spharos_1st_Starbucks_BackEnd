package TRaMis8khae.starbucks.event.application;

import TRaMis8khae.starbucks.event.dto.out.EventInfoResponseDto;
import TRaMis8khae.starbucks.event.dto.in.EventRequestDto;
import TRaMis8khae.starbucks.event.entity.Event;
import TRaMis8khae.starbucks.product.dto.out.EventProductResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;
import java.util.Optional;

public interface EventService {

    List<EventInfoResponseDto> getEventList(Long eventId);
    List<String> getProductUUID(Long eventId);

    void addEvent(EventRequestDto requestDto);
    void deleteEvent(Long eventId);

    EventInfoResponseDto getEvent(Long eventId);

    Optional<Event> findByEventName(String eventName);

    Slice<EventProductResponseDto> getEventProductList(Pageable pageable, Slice productSlice);

}
