package TRaMis8khae.starbucks.order.entity;

import jakarta.persistence.*;

@Entity
public class ReviewImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productReviewMediaId;
    private Integer imageOrder;

    @ManyToOne
    private Review review;
    @ManyToOne
    private ReviewMedia reviewMedia;
}
