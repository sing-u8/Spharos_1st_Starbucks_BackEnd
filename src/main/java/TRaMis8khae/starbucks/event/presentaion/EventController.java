package TRaMis8khae.starbucks.event.presentaion;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.event.application.EventService;
import TRaMis8khae.starbucks.event.dto.out.EventInfoResponseDto;
import TRaMis8khae.starbucks.event.dto.in.EventRequestDto;
import TRaMis8khae.starbucks.event.dto.out.EventProductResponseDto;
import TRaMis8khae.starbucks.event.entity.EventMedia;
import TRaMis8khae.starbucks.event.infrastructure.EventMediaRepository;
import TRaMis8khae.starbucks.event.vo.in.EventRequestVo;
import TRaMis8khae.starbucks.event.vo.out.EventResponseVo;
import TRaMis8khae.starbucks.event.vo.out.EventProductResponseVo;
import TRaMis8khae.starbucks.media.infrastructure.MediaRepository;
import TRaMis8khae.starbucks.product.application.ProductService;
import TRaMis8khae.starbucks.product.entity.Product;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private final EventMediaRepository eventMediaRepository;
    private final MediaRepository mediaRepository;

    @Operation(summary = "이벤트 생성 API", description = "createEvent API", tags = {"Event"})
    @PostMapping("/event")
    public BaseResponse<EventRequestVo> createEvent(@RequestBody EventRequestVo requestVo) {

        EventRequestDto requestDto = EventRequestDto.toDto(requestVo);

        eventService.addEvent(requestDto);

        return null;

    }

    @Operation(summary = "이벤트 조회 API", description = "getEventList API", tags = {"Event"})
    @GetMapping("/event/{eventId}")
    public BaseResponse<List<EventResponseVo>> getEventList(@PathVariable Long eventId) {

        EventInfoResponseDto responseDto = eventService.getEvent(eventId);
        EventResponseVo responseVo = responseDto.toVo();

        return new BaseResponse<>(
                List.of(responseVo)
        );

    }

    @Operation(summary = "이벤트 상품 조회 API", description = "getEventProductList API", tags = {"Event"})
    @GetMapping("/event/product/{eventId}")
    public BaseResponse<Slice<EventProductResponseVo>> getEventProductList(
            @PathVariable Long eventId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);

        List<String> productUUID = eventService.getProductUUID(eventId);

        Slice<Product> products = productService.findProductsByProductUUID(productUUID, pageable);

        Slice<EventProductResponseVo> responseVos = products.map(product ->{

            Long mediaId = eventMediaRepository.findByProductId(product.getId()).getMediaId();
            String media = mediaRepository.findById(mediaId).get().getMediaUrl();

            EventProductResponseDto responseDto = EventProductResponseDto.toDto(
                    product, media);

            return EventProductResponseDto.toVo(responseDto);
        });

        return new BaseResponse<>(responseVos);

    }

    @Operation(summary = "이벤트 삭제 API", description = "deleteEvent API", tags = {"Event"})
    @DeleteMapping("/event/{eventId}")
    public BaseResponse<Void> deleteEvent(@PathVariable Long eventId) {

        eventService.deleteEvent(eventId);

        return new BaseResponse<>(BaseResponseStatus.SUCCESS);


    }
}
