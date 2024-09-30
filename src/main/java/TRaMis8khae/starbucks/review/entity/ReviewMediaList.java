package TRaMis8khae.starbucks.review.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class ReviewMediaList {

    @Id @GeneratedValue
    private Long id;

    private Long mediaId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Review review;

    @Builder
    public ReviewMediaList(Long mediaId, Review review) {
        this.mediaId = mediaId;
        this.review = review;
    }
}