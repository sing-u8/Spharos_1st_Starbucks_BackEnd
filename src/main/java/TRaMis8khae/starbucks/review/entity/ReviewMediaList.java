package TRaMis8khae.starbucks.review.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class ReviewMediaList {

    @Id @GeneratedValue
    private Long id;

    private Long reviewId;

    private Long mediaId;

}