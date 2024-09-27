package TRaMis8khae.starbucks.event.application;

import TRaMis8khae.starbucks.event.dto.out.EventInfoResponseDto;
import TRaMis8khae.starbucks.event.dto.in.EventRequestDto;
import TRaMis8khae.starbucks.event.entity.Event;
import TRaMis8khae.starbucks.event.infrastructure.EventRepository;
import TRaMis8khae.starbucks.event.infrastructure.EventProductListRepository;
import TRaMis8khae.starbucks.product.dto.out.EventProductResponseDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Slf4j
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventProductListRepository eventProductListRepository;

    @Override
    public List<EventInfoResponseDto> getEventList(Long eventId) {

        return eventRepository.findAll().stream()
                .map(EventInfoResponseDto::toDto)
                .toList();

    }

    @Override
    public List<String> getProductUUID(Long eventId) {

       return eventProductListRepository.findAllByEventId(eventId)
               .stream()
               .map(productEventList -> productEventList.getProductUUID())
               .toList();

    }

    @Override
    public void addEvent(EventRequestDto requestDto) {

        Event event = requestDto.toEntity(requestDto);

        eventRepository.save(event);

    }

    @Override
    @Transactional
    public void deleteEvent(Long eventId) {

        eventRepository.deleteById(eventId);

    }

    @Override
    public EventInfoResponseDto getEvent(Long eventId) {

        Optional<Event> event = eventRepository.findById(eventId);

        return event.map(EventInfoResponseDto::toDto).orElse(null);

    }

    @Override
    public Optional<Event> findByEventName(String eventName) {

        return eventRepository.findByEventName(eventName);

    }

    @Override
    public Slice<EventProductResponseDto> getEventProductList(Pageable pageable, Slice productSlice) {

        return null;
    }

}