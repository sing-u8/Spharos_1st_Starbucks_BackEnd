package TRaMis8khae.starbucks.event.presentaion;

import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
import TRaMis8khae.starbucks.event.application.EventInfoService;
import TRaMis8khae.starbucks.event.dto.EventInfoResponseDto;
import TRaMis8khae.starbucks.event.vo.EventProductResponseVo;
import TRaMis8khae.starbucks.event.vo.EventResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class EventController {

    private final EventInfoService eventInfoService;

    @GetMapping("/product/event")
    public CommonResponseEntity<List<EventResponseVo>> getEventList() {

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage() ,
                eventInfoService.getEventList().stream().map(EventInfoResponseDto::toVo).toList()
        );

    }

}
