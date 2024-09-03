package TRaMis8khae.starbucks.review.entity;

import jakarta.persistence.*;

@Entity
public class ReviewMediaList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productReviewMediaId;
    private Integer imageOrder;

    @ManyToOne
    private Review review;
    @ManyToOne
    private ReviewMedia reviewMedia;
}
