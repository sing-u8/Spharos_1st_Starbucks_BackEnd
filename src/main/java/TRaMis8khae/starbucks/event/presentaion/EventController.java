package TRaMis8khae.starbucks.event.presentaion;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
import TRaMis8khae.starbucks.event.application.EventInfoService;
import TRaMis8khae.starbucks.event.dto.EventInfoResponseDto;
import TRaMis8khae.starbucks.event.dto.EventProductResponseDto;
import TRaMis8khae.starbucks.event.vo.EventInfoResponseVo;
import TRaMis8khae.starbucks.event.vo.EventProductResponseVo;
import TRaMis8khae.starbucks.product.application.ProductService;
import TRaMis8khae.starbucks.product.entity.Product;
import jakarta.websocket.server.PathParam;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.SimpleTimeZone;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class EventController {

    private final EventInfoService eventInfoService;
    private final ProductService productService;

    @GetMapping("/event")
    public BaseResponse<List<EventInfoResponseVo>> getEventList(Long eventId) {

        return new BaseResponse<>(
                eventInfoService.getEventList(eventId).stream().map(EventInfoResponseDto::toVo).toList()
        );

    }

//    public CommonResponseEntity<List<EventInfoResponseVo>> getEventList() {
//
//        return new CommonResponseEntity<>(
//                HttpStatus.OK,
//                true,
//                CommonResponseMessage.SUCCESS.getMessage() ,
//                eventInfoService.getEventList().stream().map(EventInfoResponseDto::toVo).toList()
//        );
//
//    }

//    @GetMapping("/event/product/{eventId}")
//    public BaseResponse<Slice<EventProductResponseVo>> getEventProductList(@PathVariable Long eventId) {
//
//        log.info("eventId : {}", eventId);
//
//        List<String> productUUID = eventInfoService.getEventUUID(eventId);
//        List<Product> products = productService.findProductsByProductUUID(productUUID);
//
//        return new BaseResponse<>(
//                products.stream().map(EventProductResponseDto::toVo).toList()
//        );
//
//    }

    @GetMapping("/event/product/{eventId}")
    public BaseResponse<Slice<EventProductResponseVo>> getEventProductList(@PathVariable Long eventId) {
        log.info("eventId : {}", eventId);

        List<String> productUUID = eventInfoService.getEventUUID(eventId);
//        List<Product> products = productService.findProductsByProductUUID(productUUID);

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


//    public CommonResponseEntity<List<EventProductResponseVo>> getEventList(
//            @RequestParam Long eventId
//    ) {
//
//        return new CommonResponseEntity<>(
//                HttpStatus.OK,
//                true,
//                CommonResponseMessage.SUCCESS.getMessage() ,
//                eventInfoService.getEventList(eventId).stream().map(EventInfoResponseDto::toVo).toList()
//        );
//
//    }

}
