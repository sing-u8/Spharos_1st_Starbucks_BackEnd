package TRaMis8khae.starbucks.event.application;

import TRaMis8khae.starbucks.event.dto.out.EventInfoResponseDto;
import TRaMis8khae.starbucks.event.dto.in.EventRequestDto;
import TRaMis8khae.starbucks.event.entity.Event;
import TRaMis8khae.starbucks.event.entity.EventMedia;
import TRaMis8khae.starbucks.event.entity.ProductEventList;
import TRaMis8khae.starbucks.event.infrastructure.EventMediaRepository;
import TRaMis8khae.starbucks.event.infrastructure.EventRepository;
import TRaMis8khae.starbucks.event.infrastructure.ProductEventListRepository;
import TRaMis8khae.starbucks.product.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


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

    }

    @Override
    public Optional<Event> getEventWithMedia(Long eventId) {
        return eventRepository.findById(eventId);
    }

    @Override
    public EventInfoResponseDto getEvent(Long eventId) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);

        Event event = eventOptional.get();

        List<EventMedia> eventMediaList = eventMediaRepository.findByEventId(eventId);

        List<String> mediaPath = eventMediaList.stream()
                .map(EventMedia::getMediaUrl)
                .collect(toList());

        return EventInfoResponseDto.fromEntity(event, mediaPath);
    }


    // crawling event, eventProduct
    @Override
    public List<Event> addCrawlingEvent(int numberOfEvents) {

        List<Event> events = new ArrayList<>();

        for (int i = 0; i < numberOfEvents; i++) {
            Event event = Event.builder()
                    .eventName("event" + i)
                    .discountRate(10)
                    .build();
            events.add(event);
        }

        return events;

    }

    @Override
    public void assignProductsToEvents(List<Product> products, List<Event> events, int productsPerEvent) {
        int eventIndex = 0;

        for (int i = 0; i < products.size(); i += productsPerEvent) {
            int endIndex = Math.min(i + productsPerEvent, products.size());
            List<Product> productSubList = products.subList(i, endIndex);

            Event event = events.get(eventIndex);
            saveEventProductList(event, productSubList);

            eventIndex++;
            if (eventIndex >= events.size()) {
                break;
            }
        }
    }

    private void saveEventProductList(Event event, List<Product> products) {
        for (Product product : products) {
            ProductEventList productEventList = ProductEventList.builder()
                    .product(product)
                    .event(event)
                    .build();
            productEventListRepository.save(productEventList);
        }
    }

    @Override
    public void processEventProductMapping(List<Product> crawledProducts) {
        List<Event> events = addCrawlingEvent(8);
        assignProductsToEvents(crawledProducts, events, 5);
    }

}