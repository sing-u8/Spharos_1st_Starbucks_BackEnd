package TRaMis8khae.starbucks.media.vo;

import TRaMis8khae.starbucks.media.entity.MediaKind;
import TRaMis8khae.starbucks.media.entity.MediaType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MediaAddResponseVo {

    private String mediaUrl;
    private Boolean thumbCheck;
    private MediaKind mediaKind;
    private MediaType mediaType;
    private Integer mediaSeq;

    @Builder
    public MediaAddResponseVo(String mediaUrl, Boolean thumbCheck, MediaKind mediaKind, MediaType mediaType, Integer mediaSeq) {
        this.mediaUrl = mediaUrl;
        this.thumbCheck = thumbCheck;
        this.mediaKind = mediaKind;
        this.mediaType = mediaType;
        this.mediaSeq = mediaSeq;
    }

}