package TRaMis8khae.starbucks.media.vo;

import TRaMis8khae.starbucks.media.entity.MediaKind;
import TRaMis8khae.starbucks.media.entity.MediaType;
import lombok.Getter;

@Getter
public class MediaAddRequestVo {

    private String mediaUrl;
    private Boolean thumbCheck;
    private MediaType mediaType;
    private MediaKind mediaKind;
    private Integer mediaSeq;

}