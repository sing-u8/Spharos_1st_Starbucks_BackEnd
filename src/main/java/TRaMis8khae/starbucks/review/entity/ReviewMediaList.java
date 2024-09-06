package TRaMis8khae.starbucks.review.entity;

import jakarta.persistence.*;

@Entity
public class ReviewMediaList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer imageSeq;

    @ManyToOne
    private Review review;

    @ManyToOne
    private ReviewMedia reviewMedia;
    // 관계를 끊고 Media를 common에 넣어서 재활용

}