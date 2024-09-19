package TRaMis8khae.starbucks.media.dto;

import TRaMis8khae.starbucks.media.entity.Media;
import TRaMis8khae.starbucks.media.entity.MediaKind;
import TRaMis8khae.starbucks.media.entity.MediaType;
import TRaMis8khae.starbucks.media.vo.MediaAddRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MediaAddRequestDto {

    private String mediaUrl;
    private Boolean thumbCheck;
    private MediaKind mediaKind;
    private MediaType mediaType;
    private Integer mediaSeq;

    @Builder
    public MediaAddRequestDto(String mediaUrl, Boolean thumbCheck, MediaKind mediaKind, MediaType mediaType, Integer mediaSeq) {
        this.mediaUrl = mediaUrl;
        this.thumbCheck = thumbCheck;
        this.mediaKind = mediaKind;
        this.mediaType = mediaType;
        this.mediaSeq = mediaSeq;
    }


    public Media toEntity() {
        return Media.builder()
                .mediaUrl(this.mediaUrl)
                .thumbChecked(thumbCheck)
                .mediaType(mediaType)
                .mediaKind(mediaKind)
                .mediaSeq(mediaSeq)
                .build();
    }

    public static MediaAddRequestDto toDto(MediaAddRequestVo mediaAddRequestVo) {
        return MediaAddRequestDto.builder()
                .mediaUrl(mediaAddRequestVo.getMediaUrl())
                .thumbCheck(mediaAddRequestVo.getThumbCheck())
                .mediaKind(mediaAddRequestVo.getMediaKind())
                .mediaType(mediaAddRequestVo.getMediaType())
                .mediaSeq(mediaAddRequestVo.getMediaSeq())
                .build();
    }

}