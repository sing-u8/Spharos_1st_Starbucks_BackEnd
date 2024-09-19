package TRaMis8khae.starbucks.event.application;

import TRaMis8khae.starbucks.event.dto.EventInfoResponseDto;

import java.util.List;

public interface EventInfoService {

    List<EventInfoResponseDto> getEventList();

}
