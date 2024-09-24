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
import TRaMis8khae.starbucks.product.dto.ProductResponseDto;
import TRaMis8khae.starbucks.product.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class EventController {

    private final EventService eventService;
    private final ProductService productService;

    @PostMapping("/event")
    public BaseResponse<EventRequestVo> createEvent(@RequestBody EventRequestVo requestVo,
                                                    @RequestParam MultipartFile image) {

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
    public BaseResponse<Slice<EventProductResponseVo>> getEventProductList(@PathVariable Long eventId) {

        List<String> productUUID = eventService.getEventUUID(eventId);

        Pageable pageable = PageRequest.of(0, 10);

        List<ProductResponseDto> products = productService.findProductsByProductUUID(productUUID); // product코드 사용

        List<ProductResponseDto> productSlice = products.subList(0, Math.min(10, products.size()));

        Slice<EventProductResponseVo> responseVos = new SliceImpl<>(
                productSlice.stream()
                        .map(EventProductResponseDto::toVo)
                        .toList(),
                pageable,
                productSlice.size() > 10
        );

        return new BaseResponse<>(responseVos);

    }

}
