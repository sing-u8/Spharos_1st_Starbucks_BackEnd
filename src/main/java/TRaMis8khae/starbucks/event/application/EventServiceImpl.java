package TRaMis8khae.starbucks.event.application;

import TRaMis8khae.starbucks.event.dto.EventInfoResponseDto;
import TRaMis8khae.starbucks.event.dto.EventRequestDto;
import TRaMis8khae.starbucks.event.entity.Event;
import TRaMis8khae.starbucks.event.entity.EventMedia;
import TRaMis8khae.starbucks.event.infrastructure.EventMediaRepository;
import TRaMis8khae.starbucks.event.infrastructure.EventRepository;
import TRaMis8khae.starbucks.event.infrastructure.ProductEventListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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
    public List<String> getEventUUID(Long eventId) {

       return productEventListRepository.findAllByEventId(eventId)
               .stream()
               .map(productEventList -> productEventList.getProductUUID())
               .collect(Collectors.toList());

    }

    @Override
    public void addEvent(EventRequestDto requestDto, MultipartFile image) {

        Event event = requestDto.toEntity(requestDto);

        eventRepository.save(event);

        String imagePath = "D:/saved_images";
        String fileName = image.getOriginalFilename();
        File file = new File(imagePath, fileName);

        try {
            image.transferTo(file);
            EventMedia eventMedia = EventMedia.builder()
                    .path(file.getAbsolutePath())
                    .build();
        } catch (Exception e) {
            log.error("이미지 저장 실패", e);
        }

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
                .map(EventMedia::getPath)
                .collect(Collectors.toList());

        return EventInfoResponseDto.fromEntity(event, mediaPath);
    }

}