package TRaMis8khae.starbucks.order.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ReviewMedia {
    @Id
    private Long reviewMediaId;
    private String reviewMediaType;
    private String reviewMediaPath;
}
