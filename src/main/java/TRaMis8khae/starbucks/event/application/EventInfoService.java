package TRaMis8khae.starbucks.event.application;

import TRaMis8khae.starbucks.event.dto.EventInfoRequestDto;

import java.util.List;

public interface EventInfoService {

    List<EventInfoRequestDto> getEventList();

}
