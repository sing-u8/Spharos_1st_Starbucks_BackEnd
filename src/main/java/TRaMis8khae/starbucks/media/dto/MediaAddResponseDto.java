package TRaMis8khae.starbucks.media.dto;

import TRaMis8khae.starbucks.media.entity.Media;
import TRaMis8khae.starbucks.media.entity.MediaKind;
import TRaMis8khae.starbucks.media.entity.MediaType;
import TRaMis8khae.starbucks.media.vo.MediaAddResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MediaAddResponseDto {

    private String mediaUrl;
    private Boolean thumbCheck;
    private MediaKind mediaKind;
    private MediaType mediaType;
    private Integer mediaSeq;

    @Builder
    public MediaAddResponseDto(String mediaUrl, Boolean thumbCheck, MediaKind mediaKind, MediaType mediaType, Integer mediaSeq) {
        this.mediaUrl = mediaUrl;
        this.thumbCheck = thumbCheck;
        this.mediaKind = mediaKind;
        this.mediaType = mediaType;
        this.mediaSeq = mediaSeq;
    }


    public static MediaAddResponseDto toDto(Media media) {
        return MediaAddResponseDto.builder()
                .mediaUrl(media.getMediaUrl())
                .thumbCheck(media.getThumbChecked())
                .mediaKind(media.getMediaKind())
                .mediaType(media.getMediaType())
                .mediaSeq(media.getMediaSeq())
                .build();
    }

    public MediaAddResponseVo toVo() {
        return MediaAddResponseVo.builder()
                .mediaUrl(mediaUrl)
                .thumbCheck(thumbCheck)
                .mediaKind(mediaKind)
                .mediaType(mediaType)
                .mediaSeq(mediaSeq)
                .build();
    }

}