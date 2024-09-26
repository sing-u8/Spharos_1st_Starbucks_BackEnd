package TRaMis8khae.starbucks.event.application;

import TRaMis8khae.starbucks.event.dto.in.EventMediaRequestDto;
import TRaMis8khae.starbucks.event.infrastructure.EventMediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventMediaServiceImpl implements EventMediaService {

    private final EventMediaRepository eventMediaRepository;

    @Override
    public void addEventMedia(EventMediaRequestDto requestDto) {

        eventMediaRepository.save(requestDto.toEntity());

    }

}
