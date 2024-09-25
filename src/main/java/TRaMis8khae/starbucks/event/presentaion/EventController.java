package TRaMis8khae.starbucks.event.presentaion;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.event.application.EventService;
import TRaMis8khae.starbucks.event.dto.out.EventInfoResponseDto;
import TRaMis8khae.starbucks.event.dto.in.EventRequestDto;
import TRaMis8khae.starbucks.event.dto.out.EventProductResponseDto;
import TRaMis8khae.starbucks.event.vo.in.EventRequestVo;
import TRaMis8khae.starbucks.event.vo.out.EventResponseVo;
import TRaMis8khae.starbucks.event.vo.out.EventProductResponseVo;
import TRaMis8khae.starbucks.product.application.ProductService;
import TRaMis8khae.starbucks.product.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Slice;
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

    @GetMapping("/event/{eventId}")
    public BaseResponse<List<EventResponseVo>> getEventList(@PathVariable Long eventId) {

        EventInfoResponseDto responseDto = eventService.getEvent(eventId);
        EventResponseVo responseVo = responseDto.toVo();

        return new BaseResponse<>(
                List.of(responseVo)
        );

    }

    @GetMapping("/event/product/{eventId}")
    public BaseResponse<List<EventProductResponseVo>> getEventProductList(@PathVariable Long eventId) {

        List<String> productUUID = eventService.getProductUUID(eventId);

        List<Product> products = productService.findProductsByProductUUID(productUUID);// product코드 사용

        log.info("products: {}", products);

        List<EventProductResponseVo> productResponseVos = products.stream()
                .map(EventProductResponseDto::toDto)
                .map(EventProductResponseDto::toVo)
                .toList();

        return new BaseResponse<>(productResponseVos);

    }




}
