package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Engraving {
    @Id
    private Long engravingId;
    @Column(nullable = false, length = 50)
    private String name;
    private Boolean engravingChecked;
}
