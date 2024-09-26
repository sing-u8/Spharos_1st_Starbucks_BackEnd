package TRaMis8khae.starbucks.event.application;

import TRaMis8khae.starbucks.event.dto.in.ProductEventListRequestDto;
import TRaMis8khae.starbucks.event.dto.out.EventInfoResponseDto;
import TRaMis8khae.starbucks.event.dto.in.EventRequestDto;
import TRaMis8khae.starbucks.event.entity.Event;
import TRaMis8khae.starbucks.event.entity.ProductEventList;
import TRaMis8khae.starbucks.event.infrastructure.EventMediaRepository;
import TRaMis8khae.starbucks.event.infrastructure.EventRepository;
import TRaMis8khae.starbucks.event.infrastructure.ProductEventListRepository;
import TRaMis8khae.starbucks.event.vo.in.ProductEventListRequestVo;
import TRaMis8khae.starbucks.product.entity.Product;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Slf4j
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final ProductEventListRepository productEventListRepository;
    private final EventMediaRepository eventMediaRepository;

    @Override
    public List<EventInfoResponseDto> getEventList(Long eventId) {

        return eventRepository.findAll().stream()
                .map(EventInfoResponseDto::toDto)
                .toList();

    }

    @Override
    public List<String> getProductUUID(Long eventId) {

       return productEventListRepository.findAllByEventId(eventId)
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
    public void addCrawlEvent(EventRequestDto requestDto) {

        Event event = requestDto.toEntity(requestDto);

        eventRepository.save(event);

    }

    @Override
    public void addCrawlEventProduct(ProductEventListRequestDto requestDto) {

        log.info("%%%%%%%%%%%%%%%%%%%%%%productEventList: {}", requestDto);

        ProductEventList productEventList = requestDto.toEntity(requestDto.getEvent(), requestDto.getProduct());

        productEventListRepository.save(productEventList);

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

}