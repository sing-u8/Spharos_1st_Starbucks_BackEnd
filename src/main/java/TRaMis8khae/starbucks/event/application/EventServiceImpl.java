package TRaMis8khae.starbucks.event.application;

import TRaMis8khae.starbucks.event.dto.EventInfoResponseDto;
import TRaMis8khae.starbucks.event.dto.EventRequestDto;
import TRaMis8khae.starbucks.event.entity.Event;
import TRaMis8khae.starbucks.event.infrastructure.EventRepository;
import TRaMis8khae.starbucks.event.infrastructure.ProductEventListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final ProductEventListRepository productEventListRepository;

    @Override
    public List<EventInfoResponseDto> getEventList(Long eventId) {

        return eventRepository.findAll().stream()
                .map(EventInfoResponseDto::toDto)
                .toList();

    }

    @Override
    public List<String> getEventUUID(Long eventId) {

       return productEventListRepository.findAllByEventId(eventId)
               .stream()
               .map(productEventList -> productEventList.getProductUUID())
               .collect(Collectors.toList());

    }

    @Override
    public void addEvent(EventRequestDto requestDto) {

        eventRepository.save(requestDto.toEntity(requestDto));

    }

    @Override
    public Optional<Event> getEventWithMedia(Long eventId) {
        return eventRepository.findById(eventId);
    }

}