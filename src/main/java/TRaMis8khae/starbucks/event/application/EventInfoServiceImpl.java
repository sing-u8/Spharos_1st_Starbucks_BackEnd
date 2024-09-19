package TRaMis8khae.starbucks.event.application;

import TRaMis8khae.starbucks.event.dto.EventInfoResponseDto;
import TRaMis8khae.starbucks.event.infrastructure.EventInfoRepository;
import TRaMis8khae.starbucks.event.infrastructure.ProductEventListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class EventInfoServiceImpl implements EventInfoService {

    private final EventInfoRepository eventInfoRepository;
    private final ProductEventListRepository productEventListRepository;

    @Override
    public List<EventInfoResponseDto> getEventList(Long eventId) {

        return eventInfoRepository.findAll().stream()
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

}