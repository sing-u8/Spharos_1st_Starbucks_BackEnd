package TRaMis8khae.starbucks.event.presentaion;

import TRaMis8khae.starbucks.event.dto.EventInfoRequestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class EventController {

    @GetMapping("/product/event")
    public void getEventList() {
        List<EventInfoRequestDto> eventList = EventInfoRequestDto.toDto
    }

    @GetMapping("/product/event")
    public void getEventProduct(@RequestParam Long eventId) {

    }

}
