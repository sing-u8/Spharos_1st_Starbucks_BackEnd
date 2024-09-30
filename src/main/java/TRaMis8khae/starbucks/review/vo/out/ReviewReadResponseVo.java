package TRaMis8khae.starbucks.review.vo.out;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class ReviewReadResponseVo {

    private String productUUID;

    @Column(nullable = false, length = 50)
    private String memberMaskingId; // masking을 프론트에서 하거나 db 넣을 때 바로 masking

    @Column(nullable = false, length = 50)
    private String reviewContext;

    private Integer reviewScore;

    private LocalDateTime updatedAt;

    private List<Long> mediaIdList;

}