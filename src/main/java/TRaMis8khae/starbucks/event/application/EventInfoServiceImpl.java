package TRaMis8khae.starbucks.event.application;

import TRaMis8khae.starbucks.event.dto.EventInfoResponseDto;
import TRaMis8khae.starbucks.event.infrastructure.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventInfoServiceImpl implements EventInfoService {

    private final EventRepository eventRepository;

    @Override
    public List<EventInfoResponseDto> getEventList() {

        return eventRepository.findAll().stream()
                .map(EventInfoResponseDto::toDto)
                .toList();

    }

}
