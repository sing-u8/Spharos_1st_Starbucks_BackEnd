package TRaMis8khae.starbucks.event.presentaion;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.event.application.EventService;
import TRaMis8khae.starbucks.event.dto.EventInfoResponseDto;
import TRaMis8khae.starbucks.event.dto.EventProductResponseDto;
import TRaMis8khae.starbucks.event.dto.EventRequestDto;
import TRaMis8khae.starbucks.event.vo.EventRequestVo;
import TRaMis8khae.starbucks.event.vo.EventResponseVo;
import TRaMis8khae.starbucks.event.vo.EventProductResponseVo;
import TRaMis8khae.starbucks.product.application.ProductService;
import TRaMis8khae.starbucks.product.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class EventController {

    private final EventService eventService;
    private final ProductService productService;

    @PostMapping("/event")
    public BaseResponse<EventRequestVo> createEvent(@RequestBody EventRequestVo requestVo) {

        EventRequestDto requestDto = EventRequestDto.toDto(requestVo);

        eventService.addEvent(requestDto);

        return null;

    }

    @GetMapping("/event")
    public BaseResponse<List<EventResponseVo>> getEventList(Long eventId) {

        return new BaseResponse<>(
                eventService.getEventList(eventId).stream().map(EventInfoResponseDto::toVo).toList()
        );

    }

    @GetMapping("/event/product/{eventId}")
    public BaseResponse<Slice<EventProductResponseVo>> getEventProductList(@PathVariable Long eventId) {

        List<String> productUUID = eventService.getEventUUID(eventId);

        Pageable pageable = PageRequest.of(0, 10);

        List<Product> productSlice = productService.findProductsByProductUUID(productUUID);

        Slice<EventProductResponseVo> responseVos = new SliceImpl<>(
                productSlice.stream()
                        .map(EventProductResponseDto::toDto)
                        .map(EventProductResponseDto::toVo).toList(),
                pageable,
                true
        );

        return new BaseResponse<>(responseVos);

    }

}
