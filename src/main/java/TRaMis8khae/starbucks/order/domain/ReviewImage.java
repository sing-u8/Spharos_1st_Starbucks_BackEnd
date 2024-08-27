package TRaMis8khae.starbucks.order.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ReviewImage {
    @Id
    private Long productReviewMediaId;
    private Integer imageOrder;

    @ManyToOne
    private Review review;
    @ManyToOne
    private ReviewMedia reviewMedia;
}
