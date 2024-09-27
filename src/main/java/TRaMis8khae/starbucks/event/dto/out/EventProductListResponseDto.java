package TRaMis8khae.starbucks.event.dto.out;

import TRaMis8khae.starbucks.event.entity.Event;
import TRaMis8khae.starbucks.event.entity.EventMedia;
import TRaMis8khae.starbucks.event.vo.out.EventProductResponseVo;
import TRaMis8khae.starbucks.media.entity.Media;
import TRaMis8khae.starbucks.product.dto.out.EventProductResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class EventProductListResponseDto {

    private String productName;
    private Double price;
//    private String media;
//    private List<Long> mediaIdList;
//    private EventMedia eventMedia;
    private List<Media> eventMedia;

    public static EventProductListResponseDto toDto(
            EventProductResponseDto responseDto, List<Media> eventMedia) {
        return EventProductListResponseDto.builder()
                .productName(responseDto.getName())
                .price(responseDto.getPrice())
                .eventMedia(eventMedia)
                .build();
    }

    public static EventProductResponseVo toVo(EventProductListResponseDto responseDto) {
        return EventProductResponseVo.builder()
                .productName(responseDto.getProductName())
                .price(responseDto.getPrice())
//                .mediaIdList(responseDto.getProductMediaId())
                .eventMedia(responseDto.getEventMedia())
                .build();
    }

}
