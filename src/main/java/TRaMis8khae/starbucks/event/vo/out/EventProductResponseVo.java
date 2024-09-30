package TRaMis8khae.starbucks.event.vo.out;

import TRaMis8khae.starbucks.event.entity.EventMedia;
import TRaMis8khae.starbucks.media.entity.Media;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@ToString
public class EventProductResponseVo {

    private String productName;

    private Double price;

//    private String media;

//    private List<Long> mediaIdList;

//    private EventMedia eventMedia;

    private List<Media> eventMedia;

}

