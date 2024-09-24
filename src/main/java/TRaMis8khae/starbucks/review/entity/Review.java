package TRaMis8khae.starbucks.review.entity;

import TRaMis8khae.starbucks.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Entity
@ToString
@NoArgsConstructor
@Where(clause = "is_deleted = false")
@SQLDelete(sql = "UPDATE review SET is_deleted = true WHERE id = ?")
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reviewUUID;

    private String productUUID;

    private String memberUUID;

    @Column(nullable = false, length = 50)
    private String memberMaskingId; // masking을 프론트에서 하거나 db 넣을 때 바로 masking

    @Column(nullable = false, length = 50)
    private String reviewContext;

    private Integer reviewScore;

    private Boolean isDeleted = false;

    @Builder
    public Review(Long id, String reviewUUID, String productUUID, String memberUUID,
                  String memberMaskingId, String reviewContext, Integer reviewScore) {
        this.id = id;
        this.reviewUUID = reviewUUID;
        this.productUUID = productUUID;
        this.memberUUID = memberUUID;
        this.memberMaskingId = memberMaskingId;
        this.reviewContext = reviewContext;
        this.reviewScore = reviewScore;
    }
}