package TRaMis8khae.starbucks.event.application;

import TRaMis8khae.starbucks.event.dto.EventInfoResponseDto;
import TRaMis8khae.starbucks.event.dto.EventProductResponseDto;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface EventInfoService {

    List<EventInfoResponseDto> getEventList(Long eventId);
    List<String> getEventUUID(Long eventId);
}
