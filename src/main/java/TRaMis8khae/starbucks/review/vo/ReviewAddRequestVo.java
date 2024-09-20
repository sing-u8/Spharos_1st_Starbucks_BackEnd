package TRaMis8khae.starbucks.review.vo;

import TRaMis8khae.starbucks.media.entity.Media;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@ToString
public class ReviewAddRequestVo {

    private String productUUID;

    private String memberUUID;

    @Column(nullable = false, length = 50)
    private String memberMaskingId; // masking을 프론트에서 하거나 db 넣을 때 바로 masking

    @Column(nullable = false, length = 50)
    private String reviewContext;

    private Integer reviewScore;

    private List<Long> mediaUrlList;

    private LocalDateTime registDate;

}